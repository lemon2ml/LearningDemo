package test;

import java.util.*;

public class Test7 {

	public static void main(String[] args) {
		
		String s= "";
		System.out.println(new Date());
		
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("--- Memory Usage:");
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total Memory = "
		+ rt.totalMemory()
		+ " Free Memory = "
		+ rt.freeMemory());
	}

}
