package com.lei.algs10.str;

import java.util.Arrays;

import edu.princeton.cs.algs4.NonrecursiveDFS;

public class Permutation {
    static void reverse(char[] a, int start, int end) {
        while (start < end) {
            char temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }

    static int findDecrease(char[] a) {
        int i;
        for (i = a.length - 1; i > 0; i--) {
            if (a[i] > a[i - 1]) {
                break;
            }
        }
        return i - 1;
    }

    static int findBigger(char[] a, int from) {
        int i = a.length - 1;
        while (a[i] <= a[from]) {
            i--;
        }
        return i;
    }

    static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static char max(char[] a) {
        char max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    static boolean nextPerm(char[] a) {
        if (a[0] == max(a)) {
            return false;
        }
        return true;
    }

    static void doNextPerm(char[] a) {
        int from = findDecrease(a);
        int big = findBigger(a, from);
        swap(a, from, big);
        reverse(a, from + 1, a.length - 1);
    }

    static void nonRecursive(char[] a) {
        Arrays.sort(a);
        while (nextPerm(a)) {
            System.out.println(Arrays.toString(a));
            doNextPerm(a);
        }
    }

    public static void main(String[] args) {
        String str = "92326520";
        char[] cs = str.toCharArray();
        nonRecursive(cs);
        
    }
}
