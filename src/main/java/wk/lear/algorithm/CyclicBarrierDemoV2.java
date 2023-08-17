package wk.lear.algorithm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:   bmfish
 * date: 2022/5/8 17:23
 * description: //再来搞一次
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class CyclicBarrierDemoV2 {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i <10 ; i++) {
            ex.execute(()->{
                System.out.println(Thread.currentThread().getId()+"到了等待");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("到了，出发");
            });

        }

    }
}
