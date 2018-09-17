package com.lei.thinkinjava;

import java.util.Arrays;

public class multidimensionArray {
    public static void main(String[] args) {
        int[][] a = new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 3 }, { 1, 4, 3 }, { 1, 2 } };
        System.out.println(Arrays.deepToString(a));
        
    }
}

class MethodParameter{
    public static<T> T[] f(T[] args) {
        return args;
    }
}
