package com.lei.algs10.array;

import java.util.Arrays;

public class EnumNumber {

    static final int SUM = 30;
    static final int[] nums = { 1, 2, 3, 7, 8, 99, 4, 5, 6 };

    static void enumNumber(boolean[] x, int i, int has) {
        if (i >= x.length) {
            return;
        }
        if (has + nums[i] == SUM) {
            x[i] = true;
            prt(nums, x);
            x[i] = false;
        }
        x[i] = true;
        enumNumber(x, i + 1, has + nums[i]);
        x[i] = false;
        enumNumber(x, i + 1, has);
    }

    private static void prt(int[] nums, boolean[] x) {
        for (int i = 0; i < nums.length; i++) {
            if (x[i] == true) {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(x));
    }

    public static void main(String[] args) {
        enumNumber(new boolean[nums.length], 0, 0);
    }
}
