package wk.yuanma.myspring.spring;

@Component()
public class UserService implements BeanNameAware,InitializingBean{

    @Autowired
    private OrderService orderService;

    private String beanName;

    public void test(){
        System.out.println("test do");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName=beanName;
    }


    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet");
    }
}
