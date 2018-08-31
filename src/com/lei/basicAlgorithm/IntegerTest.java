package com.lei.basicAlgorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerTest {

    public static void main(String[] args
            ) {
        AtomicInteger i = new AtomicInteger(40);
        change(i);
        i.intValue();
        System.out.println(i);
    }

    public static void change(AtomicInteger i) {
        i.set(55);
    }
}
