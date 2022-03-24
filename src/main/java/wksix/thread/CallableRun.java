package wksix.thread;

import java.util.concurrent.FutureTask;

/**
 * author:   bmfish
 * date: 2021/12/12 23:54
 * description: //模块目的、功能描述
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class CallableRun {
    public static void main(String[] args) throws Exception {
        MyCallable callable = new MyCallable();
        FutureTask<String> result = new FutureTask(callable);
        new Thread(result).start();
        System.out.println("CallbaleRun main start");
        System.out.println(result.get());
    }
}
