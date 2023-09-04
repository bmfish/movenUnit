package wk.lear.algorithm;

public class 发红包算法2 {

    public static void main(String[] args) {
        do03();
        //do01();
    }
   private static void do03(){

       int sum=100;
       int max= (int) (100*0.3);
       int min=1;
       int n=10;
       while (n>0) {

          if(n==1) {
              System.out.println(sum);
          }else{
              int randomMax=sum-min*(n-1);
              int radomMin=sum-max*(n-1);
              int rMax=randomMax>=max?max:randomMax;
              int rMin=radomMin<=min?min:radomMin;
              int random= (int) (rMin+Math.random()*(rMax-rMin+1));
              System.out.println(random);
              sum=sum-random;
          }
          n--;

       }
   }


    /**
     * 100快，发10个红包，每个红包最少1元，最大30%元
     */
    private static void do02(){
        int sum=100;
        int max= (int) (100*0.3);
        int min=1;
        int n=10;
        while (n>0) {
            if(n==1) {
                System.out.println(sum);
                n--;
            }else {
            int random= (int) (min+Math.random()*(max-min+1));
             if(sum-random>=1*(n-1)&&sum-random<=max*(n-1)){
                 System.out.println(random);
                 sum=sum-random;
                 n--;
             }
            }

        }





    }


    private static void do01() {
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
