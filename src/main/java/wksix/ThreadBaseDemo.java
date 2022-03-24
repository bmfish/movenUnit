package wksix;

/**
 * author:   bmfish
 * date: 2021/12/12 23:26
 * description: 线程的使用
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class ThreadBaseDemo {

    public static void main(String[] args) {
        int sum = 0;

        new Thread() {
            @Override
            public void run() {
                System.out.println("sum;");
            }
        }.start();

        Sun sun = new Sun();
        new Thread(sun).start();
        System.out.println("sum all:" + sum);
    }

    static class Sun implements Runnable {

        @Override
        public void run() {
            System.out.println("test");
        }
    }

}
