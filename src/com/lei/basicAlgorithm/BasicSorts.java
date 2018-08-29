package com.lei.basicAlgorithm;

import java.util.Arrays;
import java.util.Date;

public class BasicSorts {
    public static void bubbleSort(int[] a) {
        int len = a.length;
        int flag = len - 1;
        int index = flag;// 两个临时变量记住最后一个交换位置
        for (int i = 0; i < index; i++) {
            index = flag;
            flag = 0;
            for (int j = 0; j < index; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = j;
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

    public static void insertSort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[index] > a[j]) {
                    index = j;
                }
            }
            swap(a, index, i);
        }
    }

    public static void shellSort1(int[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < n; i++) {
                int index = i;
                for (int j = i + gap; j < n; j += gap) {
                    if (a[index] > a[j]) {
                        index = j;
                    }
                }
                swap(a, index, i);
            }
        }
    }

    public static void shellSort(int[] a) {
        int i, j, gap;
        int n = a.length;

        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {
                for (j = i - gap; j >= 0; j -= gap) {// for (j = i - gap; j >= 0 && a[j] > a[j+gap]; j -= gap) {swap();}
                    if (a[j] > a[j + gap]) {
                        swap(a, j, j + gap);
                    }
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

    public static void mergeSort(int[] a) {
        int len = a.length;
        int[] temp = new int[len];
        int left = 0, right = len - 1;
        mergeSort(a, left, right, temp);
    }

    private static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid + 1, right, temp);
            mergeSortedArray(a, left, mid, mid + 1, right, temp);
        }
    }

    private static void mergeSortedArray(int[] a, int left1, int right1, int left2, int right2, int[] temp) {
        int k = 0;
        int i = left1, j = left2;
        int m = right1, n = right2;
        while (i <= m && j <= n) {
            temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[left1 + i] = temp[i];
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

    static int arraylenght = 10000;
    static int[] a = new int[] { 1, 2, 5, 2, 3, 0, 0, 22, 33, 11, 9, 7, 6 };

    public static void main(String[] args) {
        // print(a);

        long start = 0l, end = 0l;

        // int[] a;
        print(a);
        // bs();
        shellSort1(a);
        // insertSort1(a);
        print(a);
        // is();
        //
        // ss();
        //
        // bs();
        //
        // ms();
        //
        // qs();

        // print(a);
    }

    private static void is() {
        long start;
        long end;
        int[] a;
        a = randomArray(arraylenght);
        start = new Date().getTime();
        insertSort(a);
        end = new Date().getTime();
        System.out.println("insertSort: " + (end - start) + "ms");
    }

    private static void ss() {
        long start;
        long end;
        int[] a;
        a = randomArray(arraylenght);
        start = new Date().getTime();
        selectSort(a);
        end = new Date().getTime();
        System.out.println("selectSort: " + (end - start) + "ms");
    }

    private static void qs() {
        long start;
        long end;
        int[] a;
        a = randomArray(arraylenght);
        start = new Date().getTime();
        quickSort(a);
        end = new Date().getTime();
        System.out.println("quickSort: " + (end - start) + "ms");
    }

    private static void ms() {
        long start;
        long end;
        int[] a;
        a = randomArray(arraylenght);
        start = new Date().getTime();
        mergeSort(a);
        end = new Date().getTime();
        System.out.println("mergeSort: " + (end - start) + "ms");
    }

    private static void bs() {
        long start;
        long end;
        // int[] a = randomArray(arraylenght);

        start = new Date().getTime();
        bubbleSort(a);
        end = new Date().getTime();
        System.out.println("bubleSort: " + (end - start) + "ms");
    }

    private static int[] randomArray(int lenght) {
        int[] a = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        return a;
    }
}
