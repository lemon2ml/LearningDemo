package com.lei.algs10.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Dp {
    private static int index;

    static int[][] lcs(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < b.length + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    static int getLcsLength(int[] a, int[] b) {
        int[][] dp = lcs(a, b);
        return dp[a.length][b.length];
    }

    static int[] getLcsSequence(int[] a, int[] b) {
        int[][] dp = lcs(a, b);
        int i = a.length, j = b.length;
        int len = getLcsLength(a, b);
        int[] ans = new int[len];
        while (i > 0 && j > 0 && len >= 0) {
            if (a[i - 1] == b[j - 1]) {
                i--;
                j--;
                ans[--len] = a[i];
            } else if (dp[i - 1][j] > dp[i][j - 1]) {// 往上
                i--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {// 往左
                j--;
            } else {// dp[i-1][j] == dp[i][j-1]相等情况也往左
                j--;
            }
        }
        return ans;
    }

    static int lis(int[] a, int[] pre) {
        if (pre.length < a.length) {
            pre = new int[a.length];
        }
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        int[] dp = new int[a.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }

        return max(dp);
    }

    private static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {

            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }
        return max;
    }

    private static void printLis(int[] a, int[] pre) {
        int idx = index;
        Deque<Integer> stack = new ArrayDeque<>();
        while (idx != -1) {
            stack.push(a[idx]);
            idx = pre[idx];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println();
        int[] a = { 3, 5, 7, 4, 8, 6, 7, 8, 2, 9 };
        int[] b = { 1, 3, 4, 5, 6, 7, 7, 8 };

        // test lis()
        int[] pre = new int[a.length];
        int lixLen = lis(a, pre);
        System.out.println(lixLen);
        printLis(a, pre);

        // test lcs()
        System.out.println("====================");
        int len = getLcsLength(a, b);
        System.out.println("len=" + len);
        int[] ans = getLcsSequence(a, b);
        System.out.println(Arrays.toString(ans));
    }
}
