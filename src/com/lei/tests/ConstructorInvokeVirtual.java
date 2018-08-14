package com.lei.tests;
class ConstructorInvokeVirtual 
{
	public static void main(String[] args){ 
		Person p = new Student("Li Ming", 18, "PKU");
	}
}

class Person
{
	String name="δ����"; 
	int age=-1;
	Person( String name, int age ){
		this.name=name; this.age=age; 
		sayHello();
	}
	void sayHello(){
		System.out.println( "A Person, name: " + name + ", age: "+ age );
	}
}

class Student extends Person
{
	String school="δ��ѧУ";
	Student( String name, int age, String school ){
		super( name, age );
		this.school = school;
	}
	void sayHello(){
		System.out.println( "A Student, name:" + name + ", age: "+ age + ", school: " + school );
	}
}

