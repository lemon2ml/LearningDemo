package com.lei.tests;

public class Test9{
	int a ;
	char c;
	boolean b;
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
    public static void main(String[] args) {
        //使用n=10,二进制形式为1010，则1的个数为2；
        int n = -10;
        System.out.println(n + "的二进制中1的个数：" + NumberOf1(n));
        
        System.out.println();
    }
}
