package com.lei.thinkinjava.practice.part6;

class A {
    public A() {
    }
}

class B {
    public B() {
    }
}

class C extends A{
}

public class Ex1 {
    public static void main(String[] args) {
        new C();
    }
}
