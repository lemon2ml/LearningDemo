package com.lei.hilocoder;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(",");
        int x = Integer.parseInt(s1[0]);
        int y = Integer.parseInt(s1[1]);
        String[] s2 = sc.nextLine().split(",");
        
        int len = s2.length;
        int[] xs = new int[len / 2];
        int[] ys = new int[len / 2];
        for (int i = 0; i < len / 2; i += 2) {
            xs[i] = Integer.parseInt(s2[i]);
            ys[i] = Integer.parseInt(s2[i + 1]);
        }
        int maxX = getMax(xs);
        int minX = getMin(xs);

        int maxY = getMax(ys);
        int minY = getMin(ys);
        int dis = getdis(x, y, xs, ys);
        if (isInSquare(x, y, maxX, minX, maxY, minY)) {
            System.out.println("yes," + 0);
        }else {
            System.out.println("no," + dis);
        }
    }
    static int getdis(int x, int y, int[] xs, int[] ys) {
        int min  = 0;
        for(int i = 0;i<xs.length;i++) {
            int dis = getDistance(x, y, xs[i], ys[i]);
            if(min>dis) {
                min = dis;
            }
        }
        return min;
    }

    static int getDistance(int x, int y, int maxX, int maxY) {
        double ans = Math.pow(maxX - x, 2) + Math.pow(maxY - y, 2);

        return (int) Math.sqrt(ans);

    }

    static boolean isInSquare(int x, int y, int maxX, int minX, int maxY, int minY) {
        if (x <= maxX && x >= minX && y <= maxY && y >= minY) {
            return true;
        }
        return false;
    }

    static int getMax(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    static int getMin(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > min) {
                min = a[i];
            }
        }
        return min;
    }

    static class Graph {
        int cnt;

        public Graph(int cnt) {
            this.cnt = cnt;
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
