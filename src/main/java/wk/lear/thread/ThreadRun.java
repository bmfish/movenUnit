package wk.lear.thread;

/**
 * author:   bmfish
 * date: 2021/12/12 23:58
 * description: //模块目的、功能描述
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class ThreadRun {
    public static void main(String[] args) throws Exception {
        new Thread(() -> System.out.println("test")).start();
    }
}
