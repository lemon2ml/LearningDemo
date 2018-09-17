package com.lei.thinkinjava;

//: Beetle.java //  The full    process of  initialization.
class Insect {
    int i = 9;
    int j;
    int x2 = prt(" Insect.x2   initialized");
    {
        System.out.println("Insect block i=" + i);
    }

    Insect() {
        prt("i  =   " + i + ",  j   =   " + j);
        j = 39;
    }

    static int x1 = prt("static Insect.x1   initialized");

    final int add() {
        return 0;
    }

    int add(int x) {
        return 0;
    }

    static int prt(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    int k = prt("Beetle.k   initialized");

    Beetle() {
        prt("k  =   " + k);
        prt("j  =   " + j);
    }

    static int x2 = prt("static Beetle.x2   initialized");

    static int prt(String s) {
        System.out.println(s);
        return 63;
    }

    int add(int x) {
        return 0;
    }

    public static void main(String[] args) {
        prt("Beetle constructor");
        Beetle b = new Beetle();
    }
} /// :~
