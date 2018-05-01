package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class test1 {

	public static void main(String[] args) {
		int size = 100000;
		EratoPrime ep = new EratoPrime();
		
		long time1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("开始艾氏筛法前："+time1);
		//艾氏筛法
		int[] a = ep.getErato(size);
		int count=0;
		
		for(int i=2;i<a.length;i++) {
			if(a[i] != 0) {				
				count++;
				System.out.print(a[i]+" ");
				
				if(count%10 == 0) {
					System.out.println();
				}
			}
			
		}
		System.out.println();
		long time2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("艾氏筛法所用时间："+(time2-time1)+"ms");
		
		System.out.println("\n-------------------------------");
		//常规方法
		count=0;
		for(Integer num : ep.getPrime(size)) {
			count++;
			System.out.print(num+" ");
			if(count%10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		long time3 = Calendar.getInstance().getTimeInMillis();
		System.out.println("常规方法所用时间："+(time3-time2)+"ms");
		
		
	}

}
 


class EratoPrime{
	
	
	//求出小于m的所有素数
	public int[] getErato(int m) {
		int a[] = new int[m];
		int n = (int) Math.sqrt(m);
		for(int i=2;i<m;i++) {
			a[i] = i;
		}
		ArrayList<Integer> al = getPrime(n);
		for(int i=0;i<al.size();i++) {
			int x = al.get(i);
			for(int j=2;j<m;j++) {
				if(a[j]%x==0 && a[j]!=x) {
					a[j]=0;
				}
			}
		}
		
		
		return a;
	}
	
	
	public ArrayList<Integer> getPrime(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		label1:
			for(int i=3;i<n;i++) {
				for(int j=2;j<i;j++) {
					if(i%j==0) continue label1;
				}
				list.add(i);
			
			}
		
		return list;
	}
	
	
	
	
	
}



























