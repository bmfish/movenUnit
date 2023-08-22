package wk.lear.thread.looksuport;

import java.util.concurrent.locks.LockSupport;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA=new Thread(()->{
            int sum=10;
            for (int i = 0; i < 10; i++) {
                sum+=i;
            }
            LockSupport.park();
            System.out.println(sum);
        });
        threadA.start();
        System.out.println("===========start");
        Thread.sleep(1000);
        System.out.println("===========end01");
        LockSupport.unpark(threadA);
        System.out.println("===========end02");

    }
}
