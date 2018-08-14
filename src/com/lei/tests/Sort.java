package com.lei.tests;

public class Sort {
	public void quickSort(int s[], int l, int r) {
		if(l<r) {
			int i = adjust(s, l, r);
			quickSort(s, l, i-1);
			quickSort(s, i+1, r);
		}
	}
	
	public int adjust(int s[], int l, int r) {
		int x = s[l];
		while(l<r) {
			while(l<r && s[r]>=x)r--;
			if(l<r)s[l] = s[r];
			
			while(l<r && s[l]<=x)l++;
			if(l<r)s[r] = s[l];
		}		
		s[l] = x;
		return l;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = new int[] {2,5,1,3,6,4,8,-1,2};
		new Sort().quickSort(s, 0, s.length-1);
		for(int i=0;i<s.length;i++) {
			System.out.print(s[i]+" ");
		}
	}

}
