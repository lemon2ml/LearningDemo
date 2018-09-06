package com.lei.basicAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int[] result = new int[8];
	public static void main(String[] args) {
		// 举行一场8小时的聚会
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			List<String> list = Arrays.asList(sc.nextLine().split(","));

			int begin = Integer.valueOf(list.get(0));
			int end = Integer.valueOf(list.get(1));
			for (int i = begin - 12; i < end - 12; i++) {
				result[i]++;
			}
			if (begin == -1 && end == -1) {
				break;
			}

		}
		for (int j = 0; j < result.length; j++) {
			System.out.println("[" + (j + 12) + "," + (j + 13) + "):" + result[j]);

		}
	}

}
