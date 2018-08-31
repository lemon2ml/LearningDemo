package com.lei.basicAlgorithm;

public class Dp {

    public static int maxSubSeqSum(int[] a) {
        int len = a.length;
        int[] start = new int[len];
        int[] all = new int[len];

        start[len - 1] = a[len - 1];
        all[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            start[i] = Math.max(a[i], a[i] + start[i + 1]);// start[i] 仅跟start[i + 1}有关，可以仅用用一个变量start
            all[i] = Math.max(start[i], a[i + 1]);// 最终只要返回all[0]， 可以仅用一个变量all
        }

        return all[0];
    }

    public static int maxSubSeqSumV1(int[] a) {
        int len = a.length;
        int start = a[len - 1];
        int all = a[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            start = Math.max(a[i], a[i] + start);// start < 0时， start = a[i]。可以改进更清新写法 
            all = Math.max(start, all);
        }

        return all;
    }

    public static int maxSubSeqSumV2(int[] a) {
        int len = a.length;
        int start = a[len - 1];
        int all = a[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            if (start < 0) {
                start = 0;
            }
            start += a[i];
            if (start > all) {
                all = start;
            }

        }

        return all;
    }

    public static void main(String[] args) {
        System.out.println();
        int[] a = new int[] { 1, 3, 5, 2, -1, 0, 8, -7, 9 };
        int[] b = new int[] { 1, 3, 5, 2, -1, 0, 8, -3, -7, 9 };
        int[] allNegtive = new int[] { -10, -1, -3, -5, -2, -4 };
        int maxSqa = maxSubSeqSumV1(a);
        int maxSqb = maxSubSeqSumV1(b);
        System.out.println(maxSqa);
        System.out.println(maxSqb);

        System.out.println(maxSubSeqSum(allNegtive));
        
    }
}
