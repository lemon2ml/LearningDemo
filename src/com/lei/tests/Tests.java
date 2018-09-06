package com.lei.tests;

public class Tests {

	static void selectSort(int[] a) {
		int len = a.length;
		int i = 0;
		int j = 0;
		for (i = 0; i < len; i++) {
			for (j = i; j > 0 && a[j] < a[j - 1]; j--) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp; 
			}

		}
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 23, 5, 2, 7, 3,2,3,5,23,99};
		print(a);
		selectSort(a);
		print(a);
	}

}
