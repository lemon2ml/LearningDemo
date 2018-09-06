package com.lei.basicAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// (+ (* 22 3) (^ 41))
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack1 = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		int res = -1;
		char[] cs = sc.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (!(c == '(' || c == ')' || c == '+' || c == '^' || c == '*')) {
				sb.append(c);
			}
		}
		String[] nums = sb.toString().split(" ");
		for (int i = 0; i < nums.length; i++) {
			String num = nums[i];
			if (num != " ") {
				queue.add(Integer.valueOf(num));
			}
		}
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];

			switch (c) {
			case ')':
				if (!(stack1.pop() == '('))
					res = -1;
				break;

			case '(':
				stack1.push(c);
				break;

			case '+':
				if (queue.size() >= 2) {
					int a = queue.poll();
					int b = queue.poll();
				}
				break;

			case '*':
				break;

			case '^':
				break;
			default:
				break;

			}
		}

	}
}
