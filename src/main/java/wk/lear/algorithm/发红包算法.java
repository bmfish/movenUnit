package wk.lear.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 发红包算法 {

    public static void main(String[] args) {

        int sum=100;
        int n=10;
        int sMax=30;
        List result=new ArrayList();
        while(n>1){
            int radmon=(int)(1+Math.random()*(30-1+1));
            if((sum-radmon>=1*(n-1)&&(sum-radmon)<=30*(n-1))){
                sum=sum-radmon;
                System.out.println(radmon+" ");
                result.add(radmon);
                n--;
            }
        }
        result.add(sum);
        System.out.println(sum);

    }

}
