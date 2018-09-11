package com.lei.algs10.str;

import java.util.Arrays;

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

    static void prt(char[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void recursive(char[] a, int from, int to) {
        if (from == to) {
            prt(a);
            System.out.println();
        } else {
            for (int i = 0; i < a.length; i++) {
                if(!isSwap()) {
                    continue;
                }
                swap(a, from, i);
                recursive(a, from + 1, to);
                swap(a, from, i);
            }
        }
    }

    private static boolean isSwap() {
        // TODO Auto-generated method stub
        return true;
    }

    public static void main(String[] args) {
        System.out.println();
        String str = "923";
        char[] cs = str.toCharArray();

        // ===================test recursive()===================
        recursive(cs, 0, cs.length - 1);

        // ===================test non-recursive()===================
//        nonRecursive(cs);

    }
}
