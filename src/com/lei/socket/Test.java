package com.lei.socket;

public class Test {

    public static void main(String[] args) {
        String str = "abcdhello";
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }

}
