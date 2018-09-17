package com.lei.algs10;

public class Str {

    static void reverse(char[] charArray, int from, int to) {
        while (from < to) {
            char t = charArray[from];
            charArray[from++] = charArray[to];
            charArray[to--] = t;
        }
    }

    // 三次拷贝
    // 时间复杂度O（n）， 空间复杂度O（m）
    static String leftRotateStringOn(String str, int m) {
        int n = str.length();
        m %= n;
        char[] cs = new char[m];
        char[] s = str.toCharArray();
        for (int i = 0; i < m; i++) {
            cs[i] = s[i];
        }
        for (int i = 0; i < n - m; i++) {
            s[i] = s[i + m];
        }
        for (int i = 0; i < m; i++) {
            s[n - m + i] = cs[i];
        }

        return new String(s);

    }

    // 暴力移位法
    // 时间复杂度O（mn）, 空间复杂度O（1）
    static String leftRotateStringOmn(String str, int m) {
        int n = str.length();
        m %= n;
        char[] s = str.toCharArray();
        for (int i = 0; i < m; i++) {
            char t = s[0];
            for (int j = 0; j <= n - 2; j++) {
                s[j] = s[j + 1];
            }
            s[n - 1] = t;
        }
        return new String(s);
    }

    // 时间复杂度O（n）， 空间复杂度O（1）
    // (X'Y')' = YX
    static String leftRotateString(String str, int m) {
        int n = str.length();
        m %= n;
        char[] charArray = str.toCharArray();
        reverse(charArray, 0, m - 1);
        reverse(charArray, m, n - 1);
        reverse(charArray, 0, n - 1);
        return new String(charArray);
    }

    static void permutation(char[] str, int from, int to) {
        if (from == to) {
            for (int i = 0; i <= to; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = from; i <= to; i++) {
            if (!isSwap(str, from, i)) {
                continue;
            }
            swap(str, i, from);
            permutation(str, from + 1, to);
            swap(str, i, from);
        }
    }

    private static boolean isSwap(char[] str, int from, int to) {
        for (int i = from; i < to; i++) {
            if (str[i] == str[to]) {
                return false;
            }
        }
        return true;
    }

    static void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    public static void main(String[] args) {
        String string = "1224";
        char[] str = string.toCharArray();
        permutation(str, 0, str.length - 1);

    }
}
