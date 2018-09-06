package com.lei.basicAlgorithm;

public class Sorts {

	static void selectSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int index = i;
			for (int j = a.length - 1; j > i; j--) {
				if (min > a[j]) {
					min = a[j];
					index = j;
				}
			}
			int temp = a[i];
			a[i] = min;
			a[index] = temp;
		}
	}

	static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int i = left, j = right;
			int x = a[left];
			while (i < j) {
				while (i < j && a[j] >= x)
					j--;
				if (i < j)
					a[i++] = a[j];
				while (i < j && a[i] < x)
					i++;
				if (i < j)
					a[j--] = a[i];

			}
			a[i] = x;
			quickSort(a, left, i - 1);
			quickSort(a, i + 1, right);
		}
	}

	static void insertSort(int[] a) {
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
		int[] a = new int[] { 1, 22,23, 5, 2, 8, 7, 3, 2, 3, 5, 23, 99 };
		print(a);
		selectSort(a);
		// insertSort(a);
		// quickSort(a);
		print(a);
	}

}
