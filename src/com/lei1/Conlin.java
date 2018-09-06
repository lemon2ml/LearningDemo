package com.lei1;

import java.util.Arrays;

public class Conlin {

	public static void main(String[] args) { 
		int[] a = new int[]{-11,-3,5, 6, -2, 3, -8, 9,-1,-10,-7,-19,19,20,22,26};
		System.out.println(Arrays.toString(a));
		new Conlin().reSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public int[] reSort(int[] a) {
		int n = a.length;
		int pos = 0, neg = 1;
		boolean flag = true;
		while(pos < n && neg < n && flag) {
			if(a[pos] > 0 && a[neg] < 0) {
				pos+=2;neg+=2;
			}else if(a[pos] < 0 && a[neg] >0){
				swap(a, pos, neg);
			}else if(a[pos] > 0 && a[neg] > 0) {
				int tmp = neg;
				for(int i=neg;i<n;i++) {
					if(a[i]<0) {
						neg = i;
						break;
					}
					if(i==n-1 && a[i]>0) {
						flag = false;
					}
				}
				neg = swap(a, tmp, neg);
			}else {//a[pos] <0 && a[neg] <0
				int tmp = pos;
				for(int i=pos;i<n;i++) {
					if(a[i]>0) {
						pos = i; 
						break;
					}
					if(i==n-1 && a[i]<0) {
						flag = false;
					}
				}
				pos = swap(a, tmp, pos);
			}
			
		}
		return a;
	}
	public int swap(int[] a, int left, int right) {
		int tmp = a[right];
		for(int i =right;i>left;i--) {
			a[i] = a[i-1];
		}
		a[left] = tmp;
		return left;
	}

}
