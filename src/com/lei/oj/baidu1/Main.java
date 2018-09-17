package com.lei.oj.baidu1;

import java.util.List;

public class Main {
    static List<int[]> list;

    static boolean isSumLessThanZero(int[] a) {
        int len = a.length;
        int sum = 0;
        for (int i = 0; i < len - 7; i++) {
            for (int j = i; j < len; j++) {
                sum += a[j];
            }
            if (sum >= 0) {
                return false;
            }
        }
        return true;
    }

    // great common divisor 最大公约数,辗转相除法
    static int gcd(int a, int b) {// recursive
        return b == 0 ? a : gcd(b, a % b);
    }

    // great common divisor 最大公约数,辗转相除法
    // non-recursive
    static int gcdNonRecursive(int a, int b) {
        int x = a % b;
        while (x != 0) {
            a = b;
            b = x;
            x = a % b;
        }
        return b;
    }

    // 更相减损法
    // recursive
    static int gcd2(int a, int b) {
        int ans = 1;
        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
            ans *= 2;
        }
        if(a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        return ans * (a == b ? b : gcd2(b, a - b));
    }

    // 红黑积木和最大值， 红色积木A上正数A， 黑色积木上负数B，选17个积木，使得：每7个相邻积木之和小于0，求17个积木之和最大值。
    static int sum(int a, int b) {
        int i;
        int sum = 0;
        for (i = 7; i > 0; i--) {
            if (i * a + (7 - i) * b < 0) {
                break;
            }
        }
        if (i >= 3) {
            sum = 2 * i * a + 2 * (7 - i) * b + 3 * a;
        } else {
            sum = 2 * i * a + 2 * (7 - i) * b + i * b + (3 - i) * b;
        }
        return sum;
    }

    // 输入N, 0 < a < b < c <= N, 素勾股数: a, b, c互素且a^2 + b^2 = c^2.求素勾股数的个数
    static int num(int N) {
        int i, j, k;
        int count = 0;
        for (i = 1; i <= N; i++) {
            for (j = i + 1; j <= N; j++) {
                for (k = j + 1; k <= N; k++) {
                    if (gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(k, i) == 1 && i * i + j * j == k * k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 102;
        int b = 21;
        int g1 = gcd2(a, b);
        int g2 = gcdNonRecursive(a, b);
        System.out.println(String.format("g1=%d; g2=%d", g1, g2));

        System.out.println(num(100));

        System.out.println(sum(10, -61));
    }
}
