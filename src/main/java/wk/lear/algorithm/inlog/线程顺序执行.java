package wk.lear.algorithm.inlog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程顺序执行 {

    private final static Object lock = new Object();
    //A是否已经执行
    private static boolean aExecuted = false;
    //B是否已经执行过
    private static boolean bExecuted = false;

    public static void printA() {
        synchronized (lock) {
            System.out.println("A");
            aExecuted = true;
            //唤醒所有等待线程
            lock.notifyAll();
        }
    }

    public static void printB() throws InterruptedException {
        synchronized (lock) {
            //获取到锁，但是要等A执行
            while (!aExecuted) {
                lock.wait();
            }
            System.out.println("B");
            bExecuted = true;
            lock.notifyAll();
        }
    }
    public static void printC() throws InterruptedException {
        synchronized (lock) {
            //获取到锁，但是要等B执行
            while (!bExecuted) {
                lock.wait();
            }
            System.out.println("C");
        }
    }

    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(10);
        ex.execute(() ->{
            printA();
        });

        ex.execute(() ->{
            try {
                printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ex.execute(() ->{
            try {
                printC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
