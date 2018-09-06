package com.lei.tests;

import java.util.Scanner;

public class Mainx {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
		    
			String[] strs = sc.nextLine().split(" ");
			int sum = 0;
			sum = Integer.valueOf(strs[0]) + Integer.valueOf(strs[1]);
			System.out.println(sum);
		}
	}

}
