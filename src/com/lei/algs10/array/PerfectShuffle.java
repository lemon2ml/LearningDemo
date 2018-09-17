package com.lei.algs10.array;

import java.util.Arrays;

public class PerfectShuffle {

    static void cycleLeader(int[] a, int from, int mod) {
        int i, t;
        for (i = (from * 2 + 1) % mod; i != from; i = (i * 2 + 1) % mod) {
            t = a[i];
            a[i] = a[from];
            a[from] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7 };
        int mod = a.length + 1;

        System.out.println(Arrays.toString(a));
        cycleLeader(a, 0, mod);
        System.out.println(Arrays.toString(a));
        cycleLeader(a, 2, mod);
        System.out.println(Arrays.toString(a));
    }
}
