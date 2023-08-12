package wk.suanfa;

public class 大数相加 {

    public static void main(String[] args) {

        String a="123456789998564";
        String b="243634593453";
        int aIndex=1;
        int bIndex=1;
        int flag=0;
        String result="";
        while(aIndex<=a.length()||bIndex<=b.length()||flag>0){
            int aNum = aIndex<=a.length()?a.charAt(a.length()-aIndex)-'0':0;
            int bNum = bIndex<=b.length()?b.charAt(b.length()-bIndex)-'0':0;

            result=(aNum+bNum+flag)%10+result;
            flag=(aNum+bNum+flag)/10;
            aIndex++;
            bIndex++;
        }
        System.out.println(result);
    }
}
