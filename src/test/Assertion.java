package test;

class Assertion {
	public static void main(String[] args)	{
		
		System.out.println("hah1.");
		assert hypotenuse(3,4)==6 : "�㷨����ȷ";
		
		System.out.println("hah2.");
	}
	static double hypotenuse( double x, double y ){
		return Math.sqrt( x*x + y*y+2);
	}
}
