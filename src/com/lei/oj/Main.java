package com.lei.oj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if(!sc.hasNext()) {
                break;
            }
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, a.length - 1);

        int[] b = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            b[i] = Math.max(a[i] - a[i - 1], a[i + 1] - a[i]);
            if (max < b[i]) {
                max = b[i];
            }
        }
        System.out.println(max);
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left, j = right, x = a[left];
            while (i < j) {
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
            }
            a[i] = x;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }
}