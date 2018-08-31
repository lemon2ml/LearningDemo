package com.lei.basicAlgorithm;

public class MoreWindows {

    static int[] findTwoRepeatedElementInArray(int[] arr) {
        int temp = 0;
        int i = 0, j = 0;
        int[] res = new int[2];
        for (i = 0; i < arr.length; i++) {
            temp ^= arr[i];// temp = 0x...1..0
        }
        for (j = 0; j < 32; j++) {
            if (((temp >> j) & 1) == 1) {
                break;
            }
        }

        for (i = 0; i < arr.length; i++) {
            if ((arr[i] >> j & 1) == 0) {
                res[0] ^= arr[i];
            } else {
                res[1] ^= arr[i];
            }
        }
        return res;

    }

    public static int findOnlyOnecInArray(int[] arr) {
        int[] count = new int[33];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= 32; j++) {
                if (((arr[i] >> j) & 1) == 1) {
                    count[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 1; i < 33; i++) {
            if (count[i] % 3 != 0) {
                res += (1 << i);
            }

        }
        return res;
    }

    private static int getMax(int[] count) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 2, 2, 3, 5, 4, 4 };
        int[] res = findTwoRepeatedElementInArray(arr);
        System.out.println(String.format("res[0]=%d, res[1]=%d", res[0], res[1]));

        arr = new int[] { 1, 2, 3, 1, 2, 3, 1, 10, 2, 3, 8, 9, 8, 8, 10, 10 };
        int r = findOnlyOnecInArray(arr);
        System.out.println(r);
    }
}
