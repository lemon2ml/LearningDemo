package test;

import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
public class Test12 {
	public static void main(String[] a) {
		 
		int[][] matrix = new int[][] {{1,2},{3,4}};
		ArrayList al = new Test12().printMatrix(matrix);
		System.out.println(al.toString());
		int m = 1;
		int n =2;
		System.out.println();
		System.out.println(m<n?m:n);
	}
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> al = new ArrayList<Integer>();
        int i = 0, j = 0;
        int count = 0;
        
        while(al.size() < m*n){
            al.addAll(read(matrix, m-count, n-count, i++, j++));
            count += 2;
        }
        return al;
    }
    
    public ArrayList<Integer> read(int[][] matrix, int m, int n, int i, int j){

        System.out.println("i="+i+",j="+j);
    	ArrayList<Integer> al = new ArrayList<Integer>();
        for(int k=0;k<n&&i<=j;k++) al.add(matrix[i][j++]);
        j--;
        System.out.println("i="+i+",j="+j);
        for(int k=0;k<m-1&&i<=j;k++) al.add(matrix[++i][j]);
        for(int k=0;k<n-1&&i>=j;k++) al.add(matrix[i][--j]);
        for(int k=0;k<m-2&&i>=j;k++) al.add(matrix[--i][j]);
        return al;
    }
}