package wk.lear.algorithm;


import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i <100 ; i++) {
            new Worker(semaphore,""+i).start();
        }

    }

    static class Worker extends Thread {
        private Semaphore semaphore;
        private String name;

        Worker(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                 if(!semaphore.tryAcquire()){
                     System.out.println("工人"+this.name+"未搶到機器");
                     return ;
                 }

                System.out.println("工人"+this.name+"占用一个机器在生产...");
                Thread.sleep(10);
                System.out.println("工人"+this.name+"释放出机器");
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
