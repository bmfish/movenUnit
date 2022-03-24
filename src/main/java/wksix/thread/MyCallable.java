package wksix.thread;

import java.util.concurrent.Callable;

/**
 * author:   bmfish
 * date: 2021/12/12 23:53
 * description: //模块目的、功能描述
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("callback start");
        return "success";
    }
}
