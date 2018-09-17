package com.lei.algs10.str;

import java.util.Arrays;

public class KMP {

    static void generateNext(char[] pattern, int[] next) {
        int i = 0;
        next[i] = -1;
        int j = next[i];

        while (i < pattern.length) {
            if (j == -1 || pattern[i] == pattern[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }

    }

    static void generateNext2(char[] pattern, int[] next) {
        int i = 0;
        next[i] = -1;
        int j = next[i];

        while (i < pattern.length - 1) {
            if (j == -1 || pattern[i] == pattern[j]) {
                ++i;
                ++j;
                if (pattern[i] == pattern[j]) {
                    next[i] = next[j];
                } else {
                    next[i] = j;
                }
            } else {
                j = next[j];
            }
        }

    }

    static int kmp(char[] text, char[] pattern) {
        int[] next = new int[pattern.length + 1];
        System.out.println(Arrays.toString(pattern));
        generateNext(pattern, next);
        System.out.println(Arrays.toString(next));

        generateNext2(pattern, next);
        System.out.println(Arrays.toString(next));
        int i = 0;
        int j = 0;
        while (i < text.length) {
            if (j == -1 || text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == pattern.length) {
                break;
            }
        }
        return i - j;
    }

    static int powerString(char[] str) {
        int[] next = new int[str.length + 1];
        generateNext(str, next);

        int len = str.length;

        if (len % (len - next[len]) == 0 && next[len] != 0) {
            return len - next[len];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // ================= test kmp() ===================//
        char[] str = "abcdabcdabcd".toCharArray();
        int ps = powerString(str);
        System.out.println(ps);

        // ================= test kmp() ===================//
        String text = "123agdadscssdfjl";
        String pattern = "cssdccsacs";
        int index = kmp(text.toCharArray(), pattern.toCharArray());
        System.out.println(index);
    }
}
