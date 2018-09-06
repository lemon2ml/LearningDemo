package com.lei.javaSourceCode;

public class NormalHash {
    /**
     * 加法哈希
     * 
     * @param key
     * @param prime
     * @return 哈希值
     */
    public static int addictiveHash(String key, int prime) {
        int hash, i;
        for (hash = key.length(), i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return hash % prime;
    }

    public static int rotatingHash(String key, int prime) {
        int hash, i;
        for (hash = key.length(), i = 0; i < key.length(); i++) {
            hash = (hash >> 4 ^ hash << 28) ^ key.charAt(i);
        }
        return hash % prime;
    }

    public static void main(String[] args) {
        String key = "apple";
        int prime = 2;

        int hash = addictiveHash(key, prime);
        System.out.println(hash);
        
        int a = 0xff;// 255
        int b = 0b01001; //1 + 8 = 9
        int c = 01013;// 3 + 8 + 8^3 = 3 + 8 + 512 = 523
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
