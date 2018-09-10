package com.lei.algs10.str;

import java.util.Arrays;

/**
 * @author Administrator
 *
 */
public class KMP {
    /**
     * findByBruteForce method
     * 
     * @param s
     *            string to be searched
     * @param p
     *            pattern
     * @return the index of pattern p first appeared in string s
     */
    static int findByBruteForce(final char[] s, final char[] p) {
        for (int i = 0; i <= s.length - p.length; i++) {
            for (int j = 0; j < p.length; j++) {

                if (s[j + i] != p[j]) {
                    break;
                }
                if (j == p.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int kmp(char[] text, char[] pattern) {
        int[] next = new int[pattern.length + 1];
        generateNext4KMP(pattern, next);
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

    static void generateNext4KMP(char[] pattern, int[] next) {
        int i = 0, j = 0;
        next[i] = -1;
        j = next[i];
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

    // 用于求powerstring周期串的next数组
    static void generateNext4PS(char[] pattern, int[] next) {// next.length == pattern.length+1
        int i = 0, j = 0;
        next[i] = -1;
        j = next[i];
        while (i < pattern.length) {
            if (j == -1 || pattern[i] == pattern[j]) {
                next[++i] = ++j;// max(i) == next.length - 1 == pattern.length
            } else {
                j = next[j];
            }
        }
    }

    static int getPowerString(String str) {
        int len = str.length();
        int[] next = new int[len + 1];
        generateNext4PS(str.toCharArray(), next);
        if (next[len]!=0 && len % (len - next[len]) == 0) {
            return len - next[len];
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        String text = "abcdeftasfdabcabcabceftljl";
        String str = "aabcdabcdabcd";
        
        int indexOfPS = getPowerString(str);
        System.out.println("indexOfPS=" + indexOfPS);
        
        char[] pattern = str.toCharArray();
        int[] next = new int[pattern.length + 1];

        int index = kmp(text.toCharArray(), pattern);
        System.out.println("index=" + index);

        System.out.println(Arrays.toString(pattern));

        generateNext4PS(pattern, next);
        System.out.println(Arrays.toString(next));

        generateNext4KMP(pattern, next);
        System.out.println(Arrays.toString(next));
        // String str = "abcdesftadsfd";
        // String pattern = "sfd";
        // int index = findByBruteForce(str.toCharArray(), pattern.toCharArray());
        // System.out.println(index);
    }

}