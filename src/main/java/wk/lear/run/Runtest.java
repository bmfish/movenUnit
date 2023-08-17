/*
 * FileName: Runtest.java
 * Author:   bm
 * Date:     2020-05-24 12:54:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2020-05-24 12:54:14> <version> <desc> <source>
 *
 */

package wk.lear.run;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runtest {
  public void  test(){
      ExecutorService exec = Executors.newFixedThreadPool(10);
      CountDownLatch countDownLatch = new CountDownLatch(10);

      try {
          for (int i = 0; i < 10; i++) {
              exec.execute(new SoSysAutoRunnable("序号:" + i, countDownLatch));
          }
          countDownLatch.await();

      } catch (InterruptedException e) {
          e.printStackTrace();
      }finally {
          exec.shutdownNow();
          System.out.println("===========over");
      }
      Thread.currentThread().interrupt();
      System.out.println("==================end");
    }

    private  class SoSysAutoRunnable implements Runnable {

        private CountDownLatch countDownLatch;
        private String s;

        public SoSysAutoRunnable(String s, CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            this.s = s;
        }

        @Override
        public void run() {
            try {
                countDownLatch.countDown();

                Thread.sleep(10000);
                System.out.println("hello world");
            } catch (Exception e) {
                System.out.println(s + " error --------");
            } finally {

                System.out.println(s + "countDown --------");
            }
        }
    }
}
