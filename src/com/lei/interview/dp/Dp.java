package com.lei.interview.dp;

public class Dp {

    /*
     * weight = {1, 2, 4, 5} value = {2, 3, 4, 9} capacity = 10
     */
    static int knapsackV1(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length][capacity + 1];
        for (int i = 0; i < dp.length; i++) {// weight.lenght
            for (int j = 0; j < dp[0].length; j++) {// capacity
                if (weight[i] > j) {// 当前物品(第i个)重量大于当前容量,所以肯定不选当前物品。
                    // 此时分两种情况：1， 当前物品为第0个物品；2， 当前物品不为第0个物品
                    // 是第0个物品，说明没有更前面的可选，那就表示可选价值为0，否则，选更前面一个继续选。
                    dp[i][j] = i == 0 ? 0 : dp[i - 1][j];
                } else {
                    // 同理， 此时分两种情况：1， 当前物品为第0个物品；2， 当前物品不为第0个物品
                    // 是第0个物品，说明没有更前面的可选，那就表示可选价值为0，否则，选更前面一个继续选。
                    dp[i][j] = i == 0 ? value[i] : Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                }
            }
        }
        return dp[weight.length - 1][capacity];
    }

    // 考虑knapsackV1版本对第0个物品的处理过于繁琐，
    // 可以换个思路：当没有物品时，不管背包容量为多大，但没有物品可装，故能装的物品价值都为0。
    // 此时dp数组第1维长度+1
    static int knapsackV2(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int j = 0; j < capacity; j++) {// 无论背包容量多大，没有物品可装，价值为0.
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {// 从第1个物品开始
            for (int j = 0; j < capacity; j++) {// 容量从0到capacity的情况
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]], dp[i - 1][j]);
                }
            }
        }
        return dp[weight.length + 1][capacity + 1];
    }

    /**
     * 最长递增子序列 longest increasing substring
     */
    static int lis(int[] a) {
        int[] dp = new int[a.length];

        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int ans = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // *********************test knapsack()******************

        int[] weight = { 2, 3, 4, 5, 9 };
        int[] value = { 3, 4, 5, 8, 10 };
        int capacity = 20;
        int v1 = knapsackV1(weight, value, capacity);
        System.out.println(v1);

        int v2 = knapsackV1(weight, value, capacity);
        System.out.println(v2);

        // *********************test lis()********************
        int idx = lis(new int[] { 1, 3, 2, 4, 5, 8, 100, 200, 300, 400, 1000, 10000 });
        System.out.println(idx);
    }
}
