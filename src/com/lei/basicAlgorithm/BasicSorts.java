package com.lei.basicAlgorithm;

import java.util.Arrays;

public class BasicSorts {
    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void selectSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }

            swap(a, i, index);
        }
    }

    // 交换：冒泡，快排
    // 选择：选择， 堆
    // 插入： 插入， 希尔
    // 归并， 基数
    public static void quickSort(int[] a) {
        int left = 0, right = a.length - 1;
        quickSort(a, left, right);
    }

    private static void quickSort(int[] a, int left, int right) {

        if (left < right) {
            int i = left, j = right;
            int x = a[left];
            while (i < j && a[j] > x) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < x) {
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

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 5, 2, 3, 33, 11, 9, 7, 6 };
        print(a);
        // bubbleSort(a);
        // insertSort(a);
        // selectSort(a);
        quickSort(a);
        print(a);
    }
}
