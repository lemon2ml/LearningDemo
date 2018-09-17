package com.lei.nowcoder.offer;

import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int cnt = 1;
            while (cnt <= 21) {
                if (cnt * n < 200 * Math.pow(1 + 0.01 * k, cnt - 1)) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }
            if (cnt > 21) {
                System.out.println("Impossible");
            }
        }
    }
}