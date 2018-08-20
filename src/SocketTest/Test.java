package SocketTest;

import java.util.Random;

public class Test {

	int a;

	public static void main(String[] args) {
		
		Random r = new Random();
		for(int i = 0;i < 40;i++) {
			int a = r.nextInt(3);
			System.out.println(a);
		}
	}
	
	
}
