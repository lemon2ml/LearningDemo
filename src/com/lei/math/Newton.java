package com.lei.math;

public class Newton {

    // 牛顿迭代法求平方根, x^2 = a,
    public static double sqrt(double a) {
        if (a < 0) {
            return Double.NaN;
        }

        double err = 1e-12;
        double x = 1;
        while (err < Math.abs(x*x -a)) {
            x = x - (Math.pow(x, 2) - a) / (x * 2);
        }
        return x;
    }

    public static void main(String[] args) {
        double a = 66;
        double res = sqrt(a);
        System.out.println(res);
    }
}
