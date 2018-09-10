package com.lei.algs10.str;

import java.util.Arrays;

public class NetherlandFlag {

    // 红白蓝三种颜色分别用0，1，2表示。数组a仅包含0，1，2三种可能值。
    static void shift(int[] a) {
        int begin = 0;
        int end = a.length - 1;
        int cur = 0;
        while (cur < a.length - 1) {
            while (a[cur] == 0 || a[cur] == 2) {
                if (a[cur] == 0 && cur >= begin) {
                    swap(a, cur, begin++);
                } else if (a[cur] == 2 && cur <= end) {
                    swap(a, cur, end--);
                } else {
                    break;
                }
            }
            cur++;
        }
    }

    static int checkI(int i) {
        return i > 0 ? i-- : i;
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = { 0, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0, 0, 2, 1, 2, 1, 2, 0, 1 };
        System.out.println(Arrays.toString(a));
        shift(a);
        System.out.println(Arrays.toString(a));
    }
}
