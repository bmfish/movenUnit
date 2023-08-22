package wk.day.thread;

import wk.lear.thread.ThreadLocalDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableRun {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable=new MyCallable();
        FutureTask<String> future=new FutureTask<>(callable);
        new Thread(future).start();
        System.out.println("main ---start-----");
        System.out.println(future.get());
        System.out.println("main ---end-----");
    }
}
