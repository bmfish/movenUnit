/*
 * FileName: A.java
 * Author:   bm
 * Date:     2021-03-14 19:59:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-03-14 19:59:31> <version> <desc> <source>
 *
 */

package wkfive.test.statictest;

public class A {
    public static int x;
    static{
        x=B.y+1;
    }
}

class B {
    public static int y=A.x+1;

    public static void main(String[] args) {
        System.out.println(A.x+"  "+B.y);
    }
}