/*
 * FileName: BigSum.java
 * Author:   bm
 * Date:     2021-03-14 21:28:17
 * Description: //大数之和
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-03-14 21:28:17> <version> <desc> <source>
 *
 */

package wk.algorithm;


public class BigSum {


    public static void main(String[] args) {
        String s1 = "147895432342";
        String s2 = "93432342864568564";
        getSum(s1,s2);
    }

    public static  String getSum(String s1, String s2) {
        StringBuffer b1 = new StringBuffer(s1);
        StringBuffer b2 = new StringBuffer(s2);

        String n1 = b1.reverse().toString();
        String n2 = b2.reverse().toString();

        int l1=n1.length();
        int l2=n2.length();
        if (l1 < l2) {
            for (int i =l1; i<l2;i++){
                n1=n1+"0";
            }
        }
        if (l1> l2) {
            for (int i =l2; i<l1;i++){
                n2=n2+"0";
            }
        }
        int c=0;
        StringBuffer result= new StringBuffer();
        for(int i=0;i<n1.length();i++){
            int sum= Integer.parseInt(n1.charAt(i)+"") +Integer.parseInt(n2.charAt(i)+"")+c;
            int a =sum%10;
            c=sum/10;
            result.append(a);
        }

        System.out.println(result.reverse().toString());

        return result.toString();
    }
}
