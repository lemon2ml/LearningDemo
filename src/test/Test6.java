package test;

public class Test6 {

	public static int a=1;
	public int b=1;
	
	public static void main(String[] args) {
//		String a=  "abcd";
//		System.out.println(f(a));
		
//		modifyA();
//		System.out.println(a);
//		modifyA();
//		System.out.println(a);
		
		int x = modifyInter();
		System.out.println(x);
		x = modifyInter();
		System.out.println(x);
	}
	
	static int f(String s) {
		
		return s.length()*2;
	}

	public static int modifyA() {
		return a++;
	}
	
	public static int modifyInter() {
		int interVariable = 10;
		return ++interVariable;
	}
	
	 
}
