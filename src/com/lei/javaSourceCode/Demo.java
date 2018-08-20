package com.lei.javaSourceCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    
    static String str;
    public static void main(String[] args) {
//        Integer 
//        String
//        Float
        Double d = 232.233234;
        System.out.println(d.toString());
        StringBuilder sb = new StringBuilder();
        ArrayList<E>
        sb.append(str);
        System.out.println(sb);
        
        byte[] a = new byte[] {1,2,3};
        byte[] dest = new byte[10];
        System.out.println(Arrays.toString(a));

        dest = Arrays.copyOf(a, 2);
        System.out.println(Arrays.toString(dest));
        str = "hello";
        char[] chs = new char[] {'h','e', 'l', 'l', 'o'};
        System.out.println(sb.append(str, 1, 3));
        
        System.out.println(str.substring(1, 2));
    }
}
