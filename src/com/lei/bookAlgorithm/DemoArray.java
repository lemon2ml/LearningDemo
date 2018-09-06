package com.lei.bookAlgorithm;

public class DemoArray {

	private static final int LINENUMBER = 5;

	// 数组最大值
	static double getMax(double[] a) {
		double max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}

		return max;
	}

	// 数组平均数
	static double getMean(double[] a) {
		int N = a.length;
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / N;
	}

	// copy a -> b
	static void copy(double[] a, double[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
	}

	// 打印數組
	static void print(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % LINENUMBER == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(arr[i] + "\t");
		}
	}

	// 数组反转
	static void reverse(double[] arr) {
		int N = arr.length;
		for (int i = 0; i < N / 2; i++) {
			double temp = arr[i];
			arr[i] = arr[N - 1 - i];
			arr[N - 1 - i] = temp;
		}
	}

	// 矩阵乘法
	static double[][] Metrix(double[][] a, double[][] b) throws Exception {
		int aRows = a[0].length;
		int bCols = b.length;
		if (aRows != bCols) {
			throw new Exception("aRows not equals bCols");
		}
		int N = aRows;
		double[][] c = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	// 打印矩阵
	static void printMetrix(double[][] metrix) {
		if (metrix == null)
			return;
		int cols = metrix[0].length;
		int rows = metrix.length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(metrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		double[][] a = new double[][] { { 1, 2 }, { 4, 5 }, { 7, 8} };
		double[][] b = new double[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] c = null;

		printMetrix(a);
		System.out.println();
		printMetrix(b);
		System.out.println();
		try {
			c = Metrix(a, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printMetrix(c);
		// double[] arr = new double[] { 1, 2, 3, 9, 8, 7, 102, 111, 56, 77, 23, 22, 54
		// };
		// print(arr);
		// reverse(arr);
		// System.out.println("\n--------------------");
		// print(arr);

		// System.out.println(getMax(arr));
		// System.out.println(getMean(arr));
		//
		// double[] b = new double[arr.length];
		// copy(arr, b);
		// print(b);
		// print(arr);

	}

}
