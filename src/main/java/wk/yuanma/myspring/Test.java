package wk.yuanma.myspring;

import wk.yuanma.myspring.spring.AppConfig;
import wk.yuanma.myspring.spring.UserService;

public class Test {

    public static void main(String[] args) {

        BmApplicationContent bmApplicationContent=new BmApplicationContent(AppConfig.class);

        UserService userService = (UserService) bmApplicationContent.getBean("userService");

        System.out.println(userService);
        userService.test();
    }
}
