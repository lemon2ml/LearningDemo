package com.lei.basicJava;
import java.util.*;

public class Demo1 {
	
	
	public static void greater() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res = a>b ? a : b;
		System.out.println(res);
	}
	public static void max() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int greater = a>b ? a : b;
		int max = greater > c ? greater : c;
		System.out.println(max);
	}
	
	public static void isLeapYear() {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		boolean b = (year%4==0 && year%100!=0 || year%400==0) ? true : false;
		System.out.println(b);
	}
	
	public static void gradeLevel() {
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		sc.close();
		char res ;
		if(grade>100 || grade < 0 ) {
			System.out.println("Illegal grade.");
			return;
		}
		if(grade>=90) res = 'A';
		else if (grade >= 80) res = 'B';
		else if (grade >= 60) res = 'C';
		else res = 'D';
		
		System.out.println(res);
	}
	
	public static void cmd() {
		System.out.println("cmd: 1. cmd1; 2. cmd2; 3. cmd3");
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		while(cnt < 20) {
			
			int cmd = sc.nextInt();
			switch(cmd) {
			case 1: System.out.println("cmd1");break;
			case 2: System.out.println("cmd2");break;
			case 3: System.out.println("cmd3");break;
			default: System.out.println("default");
			}	
			cnt++;
		}

		sc.close();
	}
	public static void multyTable() {
		for(int i = 1;i <= 9; i++) {
			for(int j = 1; j <= i; j++) {
				int prod = i * j;
				String formula = j + " * " + i + " = " + prod;
				System.out.print(formula);
				if(j<i) System.out.print("  ");
			}			
			System.out.println("\n");
		}
		
	}
	public static void min() {
		int[] arr = new int[10];
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			arr[i] = r.nextInt(100); 
		}
		System.out.println("arr:"+Arrays.toString(arr));
		int min = arr[0];
		for(int a : arr) {
			if(a<min) min = a;
		}

		System.out.println("min: " + min);
		int[] newArr = Arrays.copyOf(arr, 11);

		System.out.println("newArr: " + Arrays.toString(newArr));
		
		for(int i = newArr.length-1;i>0;i--) {
			newArr[i] = newArr[i-1];
		}
		newArr[0] = min;
		System.out.println("newArr: " + Arrays.toString(newArr));
		
		
		
	}
	
	public static void main(String[] args) {
		min();
	}
}
