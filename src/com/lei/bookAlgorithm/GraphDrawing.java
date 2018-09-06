package com.lei.bookAlgorithm;

import java.util.Scanner;

public class GraphDrawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 4;
		Scanner sc = new Scanner(System.in);
		String line = null;
		String[] lines = new String[N];
		int cnt = 0;
		while ((line = sc.nextLine()) != null) {
			lines[cnt++] = line;
			if(cnt == 4)break;
		}
		for (int i = 0; i < N; i++) {
			System.out.println(lines[i]);
		}
	}

}
