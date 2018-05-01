package test;

import java.util.Arrays;

public class Solution {
    
    public int swap(int[] a) {
    	a[1] = 0;
    	return 2;
    }
	
    public static void main(String[] args) {
		int[] a = new int[]{5, 6, -2, 3, -8, 9,-1,-10,-7,-19,19,20,22,26};

    	System.out.println(Arrays.toString(a));
		new Solution().swap(a);
		System.out.println(Arrays.toString(a));
		
    }
}