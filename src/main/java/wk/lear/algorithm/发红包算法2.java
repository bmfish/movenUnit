package wk.lear.algorithm;

public class 发红包算法2 {

    public static void main(String[] args) {
        int sum=100;
        int n=10;
        int min=1;
        int max=30;
        while(n>0){
            if(n==1){
                System.out.println(sum);
            }else {
                int nMin = (sum - max * (n - 1)) > min ? sum - max * (n - 1) : min;
                int nMax = (sum - min * (n - 1)) < max ? (sum - min * (n - 1)) : max;
                int radom = (int) (min + Math.random() * (nMax - nMin + 1));
                sum=sum-radom;
                System.out.println(radom);
            }
            n--;


        }
    }
}
