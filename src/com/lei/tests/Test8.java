package com.lei.tests;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class Test8 {
	 
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
    
        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
        
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        
        
        System.out.println();
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s1.intern()));
        
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        
        System.out.println(s1.intern() == s2.intern());
        
    }
}
