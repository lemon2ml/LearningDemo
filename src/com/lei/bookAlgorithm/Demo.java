package com.lei.bookAlgorithm;

public class Demo {
	static int count = 0;

	static boolean isDreamNum(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		// count++;
		// if (count == 100)
		// return false;
		// System.out.println(count);
		 System.out.println(n);
		if (n == 89)
			return false;
		return isDreamNum(toPower(n));

	}

	static int toPower(int n) {
		int sum = 0;
		for (String s : String.valueOf(n).split("")) {
			int a = Integer.valueOf(s);
			sum += a * a;
		}
		return sum;

	}

	public static void main(String[] args) {
		int n = 10000;
		for (int i = 777; i < 778; i++) {

			System.out.println(i + ": " + isDreamNum(i));
		}
	}

}
