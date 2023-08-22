package wk.day.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SubThreadRun {

    public static Executor ex= Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        SubThread subThread=new SubThread();
        SunRunable sunRunable=new SunRunable();
        for (int i = 0; i < 10; i++) {
            ex.execute(subThread);
            ex.execute(sunRunable);
        }

        Thread thread=new Thread(sunRunable);
        thread.start();
        System.out.println("=========end");
    }


}
