package wk.lear.algorithm.inlog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 大集合求交集 {

    public static void main(String[] args) {
        List listA=new ArrayList();
        List listB=new ArrayList();
       initData(listA,listB);
        HashSet setA=new HashSet(listA);
        HashSet setB=new HashSet(listB);

        //setA.retainAll(setB);
        setA.removeAll(setB);
        System.out.println("交集/差集："+setA.size());

    }

    private static void initData(List listA, List listB) {
        listA.clear();
        listB.clear();
        for (int i = 0; i < 10000; i++) {
            listA.add(i);
            listB.add(i + 5001);
        }
    }

}
