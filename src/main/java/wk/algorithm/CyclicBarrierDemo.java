package wk.algorithm;


import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier latch =new CyclicBarrier(3);

        new Thread(new Eator(latch,"张三")).start();
        new Thread(new Eator(latch,"李四")).start();
        new Thread(new Eator(latch,"王二")).start();

    }

    static class Eator implements Runnable {
        private CyclicBarrier barrier;
        private String name;

        Eator(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " 已经出发");
                Thread.sleep(2000);
                System.out.println(name + " 已经到达饭店");
                barrier.await();

                System.out.println(name + " 開始吃飯");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
