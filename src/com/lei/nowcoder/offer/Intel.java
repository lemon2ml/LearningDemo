package com.lei.nowcoder.offer;

import java.util.Arrays;

public class Intel {

    // 100 x 100 两个100位的数字相乘
    static String multi(String str1, String str2) {
        String[] s1 = str1.split("");
        String[] s2 = str2.split("");
        int[] si1 = new int[s1.length], si2 = new int[s2.length];
        try {
            for (int i = 0; i < s1.length; i++) {
                si1[i] = Integer.valueOf(s1[i]);
            }
            for (int i = 0; i < s2.length; i++) {
                si2[i] = Integer.valueOf(s2[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        reverse(si1);
        reverse(si2);

        int[] res = new int[si1.length + si2.length];
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                res[i + j] += si1[i] * si2[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] >= 10) {
                res[i + 1] += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }
        for (int i = 0; i < res.length; i++) {
            sb.insert(0, res[i]);
        }
        return sb.toString();
    }

    static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] + arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] = arr[i] - arr[arr.length - 1 - i];
        }
    }

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int r1 = (int) (Math.random() * 9);
            int r2 = (int) (Math.random() * 9);
            sb1.insert(0, r1);
            sb2.insert(0, r2);
        }

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

        String res = multi(sb1.toString(), sb2.toString());
        System.out.println(res);
    }

}
