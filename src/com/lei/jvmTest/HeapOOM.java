package com.lei.jvmTest;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	static class OOMObject{}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		try {

			while(true) {
				list.add(new OOMObject());
			}
		}catch(Exception e) {
			System.out.println("listsize="+list.size());
			e.printStackTrace();
		}

	}

}
