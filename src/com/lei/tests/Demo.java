package com.lei.tests;

public class Demo {
	
	public static void print(int index, String s) {
		System.out.println(String.format("{%d}, %s", index, s));
	}
	
	public static void main(String[] args) {
		char b= 'B';
		switch(b){
		
		case'A':
			print(1, ">80");
			break;
		case'B':
			print(2, "60-80");

		default:
			print(4, "δ֪");
		case'C':
			print(3, "<60");
		}
	}
}
