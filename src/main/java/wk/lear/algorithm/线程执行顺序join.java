package wk.lear.algorithm;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class 线程执行顺序join {

    public static void main(String[] args) {
        Thread a=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"thradA");
        });
        Thread b=new Thread(()->{
            try {
                a.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"thradB");
        });
        Thread c=new Thread(()->{
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"thradC");
        });

//        b.start();
//
//        c.start();
//
//        a.start();

        Executor ex= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            ex.execute(a);
            ex.execute(b);
            ex.execute(c);
        }


    }
}
