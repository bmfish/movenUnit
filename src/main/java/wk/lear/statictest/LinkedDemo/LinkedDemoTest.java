/*
 * FileName: LinkedDemoTest.java
 * Author:   bm
 * Date:     2021-03-18 00:13:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-03-18 00:13:51> <version> <desc> <source>
 *
 */

package wk.lear.statictest.LinkedDemo;

public class LinkedDemoTest {




    public static void nsout(Node nodeList) {
        System.out.println();
        while (nodeList.nextVal != null) {
            System.out.print(nodeList.key + "->");
            nodeList = nodeList.nextVal;
        }
        System.out.print(nodeList.key);
        System.out.println();
    }
}
