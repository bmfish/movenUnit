package wk.day.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("mycallable startedn");
        return "test";
    }
}
