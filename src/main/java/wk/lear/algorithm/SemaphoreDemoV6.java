package wk.lear.algorithm;

import java.util.concurrent.Semaphore;

/**
 * author:   bmfish
 * date: 2022/5/8 17:32
 * description: //模块目的、功能描述
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class SemaphoreDemoV6 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> {
                System.out.println(Thread.currentThread().getId() + "尝试获取通行证");
                try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getId() + "获取通行证成功运行中");

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "释放");
                semaphore.release();

            });
            t1.start();
        }

    }
}
