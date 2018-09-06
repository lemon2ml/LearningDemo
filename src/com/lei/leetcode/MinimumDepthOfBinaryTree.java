package com.lei.leetcode;

public class MinimumDepthOfBinaryTree {
	
	public int run(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left==null || root.right==null) {
			return Math.max(run(root.left),run(root.right))+1;
		}
		return Math.min(run(root.left), run(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}