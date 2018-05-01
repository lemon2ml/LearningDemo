package test;

public class Test3 {

	public static void doStuff(Shape s) {
		s.draw();
	}
	public static void main(String[] args) {
//		Father father = new Father();
//		Son son = new Son(5);
		 
//		Circle c = new Circle();
//		Triangle t = new Triangle();
//		Line l = new Line();
//		
//		doStuff(c);
//		doStuff(t);
//		doStuff(l);
//		
//		Shape s = new Shape();
//		doStuff(s);
//		s.draw();
//		
//		Circle c2 = new Circle();
//		c2.draw();
		
		
		Father1 f = new Son1("son1", 10);
		
		
		
	}

}


class Father1{
	String name="father1";
	public Father1() {
		sayHello();
	}
	public void sayHello() {
		System.out.println("Father sayhello, name="+name);
	}
}
class Son1 extends Father1{
	int age;
	public Son1(String name, int age) {
//		super();
		this.name = name;
		this.age = age;
		sayHello();
	}
	public void sayHello() {
		System.out.println("Son sayhello, name="+name+" age="+age);
	}
}


class Shape{
	public static void draw() {
		System.out.println("Shape drawing.");
	}
}

class Circle extends Shape{
	public static void draw() {
		System.out.println("Circle drawing.");
	}
}
class Triangle extends Shape{
	public static void draw() {
		System.out.println("Triangle drawing.");
	}
}

class Line extends Shape{
	public static void draw() {
		System.out.println("Line drawing.");
	}
}

class Father{
	public Father(int a) {
		System.out.println("class father, a="+a);
	}
}

class Son extends Father{
	public Son(int a) { 
		super(a); 
		System.out.println("class son");
	}
}