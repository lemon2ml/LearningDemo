package com.lei.jvmTest;

import java.util.ArrayList;
import java.util.List;

import com.lei.jvmTest.HeapOOM.OOMObject;

public class RuntimeConstantOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
