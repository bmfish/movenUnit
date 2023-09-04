package wk.yuanma.myspring;

import wk.yuanma.myspring.spring.*;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class BmApplicationContent {

    private Class config;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap();

    public BmApplicationContent(Class configClass) {
        this.config = configClass;
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScan.value();
            System.out.println(path);

            path = path.replace(".", "/");
            ClassLoader classLoader = BmApplicationContent.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            System.out.println(file);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    System.out.println(fileName);
                    if (fileName.endsWith(".class")) {
                        Class<?> aClass = null;
                        try {
                            String className = fileName.substring(fileName.indexOf("wk"), fileName.indexOf(".class"));
                            className = className.replace("\\", ".");
                            aClass = classLoader.loadClass(className);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        BeanDefinition beanDefinition = new BeanDefinition();
                        if (aClass.isAnnotationPresent(Component.class)) {
                            Component annotation = aClass.getAnnotation(Component.class);
                            String beanName = annotation.value();
                            if (beanName.equals("")) {
                                beanName = Introspector.decapitalize(aClass.getSimpleName());
                            }
                            if (aClass.isAnnotationPresent(Scope.class)) {
                                Scope scope = aClass.getAnnotation(Scope.class);
                                beanDefinition.setScope(scope.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinition.setType(aClass);
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }


                    }
                }


            }
        }
    }

    public Object getBean(String beanName) {

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new NullPointerException();
        }
        String scope = beanDefinition.getScope();
        if (scope.equals("singleton")) {
            Object bean = singletonObjects.get(beanName);
            if (bean == null) {
                bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName,beanDefinition);
            }

            return bean;
        } else {
            return createBean(beanName, beanDefinition);
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getType();
        try {
            Object instance = clazz.getConstructor().newInstance();
            for (Field f : clazz.getDeclaredFields()) {
                if(f.isAnnotationPresent(Autowired.class)) {
                    f.setAccessible(true);
                    f.set(instance, getBean(f.getName()));
                }

            }
            if(instance instanceof BeanNameAware){
                ((BeanNameAware) instance).setBeanName(beanName);
            }
            //初始化
            if(instance instanceof InitializingBean){
                ((InitializingBean) instance).afterPropertiesSet();
            }
            //初始后
            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }

}
