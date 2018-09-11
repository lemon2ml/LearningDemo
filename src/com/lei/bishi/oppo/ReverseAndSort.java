package com.lei.bishi.oppo;

import java.util.Arrays;

public class ReverseAndSort {
    /**
     * 随机生成10个整数
     * 
     * @return 包含10个整数的数组
     */
    public static int[] random10digits() {
        int[] digits = new int[10];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = (int) (Math.random() * 1000);
        }
        return digits;
    }

    /**
     * 翻转单个数字的字符串， 如'12345'->'54321'
     * 
     * @param str
     * @return 翻转后的整数
     */
    private static int reverse(String str) {
        String[] strArr = str.split("");

        int digit = 0;
        for (int i = 0; i < strArr.length; i++) {
            // 反转。如，["1", "2", "3"] -> 1 * 10^0 + 2 * 10^1 + 3* 10^2 = 321
            digit += Integer.valueOf(strArr[i]) * (int) (Math.pow(10, i));
        }
        return digit;
    }

    /**
     * 对整个数组的每一个数字进行翻转操作
     * 
     * @param digits
     *            翻转后的数组
     */
    public static void reverse(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = reverse(String.valueOf(digits[i]));
        }
    }

    /**
     * 快速排序
     * 
     * @param a
     *            待排序的数组
     * @param left
     *            左指针
     * @param right
     *            右指针
     */
    public static void quickSort(int[] a, int left, int right) {

        if (left < right) {
            int i = left, j = right;
            int x = a[left];
            while (i < j) {
                while (i < j && a[j] <= x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] >= x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
                a[i] = x;
                quickSort(a, left, i - 1);
                quickSort(a, i + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] digits = random10digits();

        System.out.println("随机生成： ");
        System.out.println(Arrays.toString(digits));

        reverse(digits);

        System.out.println("翻转后： ");
        System.out.println(Arrays.toString(digits));

        quickSort(digits, 0, digits.length - 1);

        System.out.println("排序后： ");
        System.out.println(Arrays.toString(digits));
    }

}
