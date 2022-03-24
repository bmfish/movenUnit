package wk.lear.algorithm;

import java.util.concurrent.CountDownLatch;

public class CountDownLaterch {

    public static void main(String[] args) {
        try {
        CountDownLatch latch =new CountDownLatch(3);

        new Thread(new Contomer(latch,"张三")).start();
        new Thread(new Contomer(latch,"李四")).start();
        new Thread(new Contomer(latch,"王二")).start();


            latch.await();
            System.out.println("服务员上菜");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


   static class Contomer implements Runnable{

        private CountDownLatch  latch;
        private  String name;

        Contomer(CountDownLatch latch, String name){
            this.latch=latch;
            this.name=name;
        }

       @Override
       public void run() {
            try {
                System.out.println(name + " 已经出发");
                Thread.sleep(5000);
                System.out.println(name + " 已经到达饭店");
                latch.countDown();
            }catch (Exception e){
                e.printStackTrace();
            }
       }
   }


}
