package wk.lear.algorithm.inlog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 线程顺序执行2 {

    private static Lock lock =new ReentrantLock();

    private static volatile int state=1;

    public static void printA(){
        while (state<100){
            try {
                lock.lock();
                if (state % 3 == 1) {
                    System.out.println("thread a");
                    state++;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public  static void printB(){
        while (state<100){
            try {
                lock.lock();
                if (state % 3 == 2) {
                    System.out.println("thread b");
                    state++;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void printC(){
        while (state<100){
            try {
                lock.lock();
                if (state % 3 == 0) {
                    System.out.println("thread c");
                    state++;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(3);
        ex.execute(()->{
            printA();
        });
        ex.execute(()->{
            printB();
        });
        ex.execute(()->{
            printC();
        });
    }

}
