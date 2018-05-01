package test;

import java.util.StringTokenizer;

public class TestSum {

	public static void main(String[] args) {

//		int a = 1;
//		int b = 2;
//		int c = new TestSum().Sum(a, b);
//		System.out.println(c);
		
		StringTokenizer st = new StringTokenizer("I love my         everyday  life.", "     ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextElement());
		}
	}
	
	public int Sum(int a, int b) {
		return a+b;
	}

}
