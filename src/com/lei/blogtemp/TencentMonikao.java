package com.lei.blogtemp;

import java.util.Scanner;

public class TencentMonikao {
    public static void main(String[] args) {
//        System.out.println(factorial(5));
        System.out.println(Long.MAX_VALUE);
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int a = sc.nextInt();
        int x = sc.nextInt();
        int b = sc.nextInt();
        int y = sc.nextInt();
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if((i * a + j * b) == k) {
                    long ans = (con(x, i) * con(y, j)) % 1000000007;
                    System.out.println(String.format("i=%d, j=%d",i, j));
                    System.out.println(ans);
                }
            }
        }
    }

    public static long con(int a, int i) {
        return factorial(a)/(factorial(i) * factorial(a - i));
    }
    
    public static long factorial(int n) {
        long ans = 1;
        while(n>0) {
            ans *= n--;
        }
        return ans;
    }
}
