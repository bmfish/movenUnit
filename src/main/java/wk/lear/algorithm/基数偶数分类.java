package wk.suanfa;

import java.util.Arrays;

public class 基数偶数分类 {

    public static void main(String[] args) {
        doEx();
    }

    public static void doEx() {
        int[] a = {2, 9, 8, 3249, 3, 1, 2, 4, 80, 7, 6, 5};
        int j = a.length - 1;
        for (int i = 0; i < j; i++) {
            if (a[i] % 2 == 0) {
                while(j > i) {
                    if (a[j] % 2 == 1) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        j--;
                        break;
                    }
                    j--;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }

    }
}
