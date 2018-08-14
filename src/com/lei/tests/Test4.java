package com.lei.tests;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test4 {
	public static void main(String args[]) {
		Test4 t4 = new Test4();
		// System.out.println(t4.getClass().getResource("."));

		// System.out.println(System.getProperties().toString());

		String x = "pwd";
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			m.update(x.getBytes("utf8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte s[] = m.digest();
		String result = "";
		for (int i = 0; i < s.length; i++) {
			System.out.println("s["+i+"]="+Integer.toBinaryString(s[i]));
			result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
		}
		System.out.println(result);

	}
}

class B {
	private B() {

	}

	static B create() {
		return new B();
	}
}

class A {
	B b = B.create();
}
