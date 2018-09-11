package com.lei.algs10.str;

import java.util.Arrays;

public class Manacher {
    // Longest Palindromic Substring
    static int lps(int[] p) {
        return max(p) - 1;
    }

    static int max(int[] p) {
        int i = 0;
        int max = p[i];
        while (++i < p.length) {
            max = max < p[i] ? p[i] : max;
        }
        return max;
    }

    static int[] generateP(char[] s) {
        // TODO 使用Manacher进行优化此函数
        int[] p = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            int k = 0;
            while (i - k >= 0 && i + k <= s.length - 1 && s[i - k] == s[i + k]) {
                k++;
            }
            p[i] = k;
        }
        return p;
    }

    static char[] generateS(String str) {
        str = "#" + String.join("#", Arrays.asList(str.split(""))) + "#";
        return str.toCharArray();
    }

    public static void main(String[] args) {
        String str = "1234328abcdeftfedcb";
        char[] s = generateS(str);
        int[] p = generateP(s);
        System.out.println(lps(p));
    }
}
