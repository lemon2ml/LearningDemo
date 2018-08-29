package com.lei.blogtemp;

public class TryFinally {
public static void main(String[] args) {
    int res = add();
    System.out.println(res);
}

static int add() {
    int a = 0;
    try {
        a += 5;
        return a += 1;
    }catch(Exception e) {
        a += 20;
        return a;
    }finally {
        a+= 1000;
        return a+test();
    }
}

static int test() {
    return 100;
}
}
