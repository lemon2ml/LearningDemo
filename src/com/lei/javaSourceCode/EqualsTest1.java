package com.lei.javaSourceCode;

public class EqualsTest1 {
    public static class Person {
        String name;
        int age;

        Person() {
        }

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.name + " - " + age;
        }
        
        public boolean equals(Object obj) {
            if(obj == null) {
                return false;
            }
            if(this == obj) {
                return true;
            }
            
            if(!(this.getClass() == obj.getClass())) {
                return false;
            }
            
            Person person = (Person) obj;
            return this.name.equals(person.name) && this.age == person.age;
              
        }
    }
    
    public static void main(String[] args) {
        Person p1 = new Person("lei", 22);
        Person p2 = new Person("lei", 22);
        Person p3 = new Person("meilian", 23);
        
        System.out.println("p1.equals(p2): " + p1.equals(p2) + " p1: " + p1.hashCode() + ";p2: " + p2.hashCode());
        System.out.println("p1.equals(p3): " + p1.equals(p3) + " p1: " + p1.hashCode() + ";p3: " + p3.hashCode());
    }
}
