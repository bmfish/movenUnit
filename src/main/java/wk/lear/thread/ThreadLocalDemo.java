package wk.lear.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:   bmfish
 * date: 2022/3/6 21:16
 * description: //模块目的、功能描述
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new ThreadLocal<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        threadPool.execute(() -> threadLocal.set("綫程1："+Thread.currentThread().getName()));
      


    }
}
