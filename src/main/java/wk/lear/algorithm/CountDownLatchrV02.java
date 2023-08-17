package wk.lear.algorithm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:   bmfish
 * date: 2022/5/8 17:15
 * description: 自己在写一下，记录一下
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class CountDownLatchrV02 {

    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            ex.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getId() + "到了");
            });
        }

        System.out.println(Thread.currentThread().getName() + "等待中");
        countDownLatch.await();
        System.out.println("人都到齐了");

    }
}
