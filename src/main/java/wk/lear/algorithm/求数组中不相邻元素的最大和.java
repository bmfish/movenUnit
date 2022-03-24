package wk.lear.algorithm;

public class 求数组中不相邻元素的最大和 {

    public static void main(String[] args) {
       // int s[]={1,2,3,1,1,9,8,-6};
        int s[]={1,2,4,1,7,8,3};
        int dp[]=new int[s.length];
        dp[0]=Math.max(s[0],0);
        dp[1]=Math.max(s[2],s[1]);
        for (int i = 2; i <s.length ; i++) {

            int a=dp[i-2]+Math.max(s[i],0);
            int b=dp[i-1];
            dp[i]=Math.max(a,b);
            System.out.println(dp[i]);
        }
    }
}
