package test;

import java.io.IOException;

public class TestFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = new TestFinally().tf();
		System.out.println(a);
	}
	
	public int tf() {
		int a=0;
		try {
			a=100;
			throw new IOException();
		}catch (IOException e) {
			return a;
		}catch(Exception e){
			return a;
		}finally {
		
			a = 300;

			System.out.println("hello world.");
		}
	}

}
