package com.lei.tests;

public class CustomException extends Exception{

	public static void main(String[] args) {
		
		int x=0;
		CustomException ce = new CustomException();
		try {
			ce.useCE(x);
		}catch (CustomException e) {
			System.out.println(e);
		}finally{
			System.out.println("Here is finally");
		}
	}
	
	public void useCE(int x) throws CustomException{

		while(x<10) {
			x++;
			System.out.println("x="+x);
		}
		throw new CustomException("The value of x is not less than 10!");
		
	}
	
	public CustomException() {
		
	};
	public CustomException(String message) {
		super(message);
	}
	public CustomException(String message, Exception cause) {
		super(message,cause);
	}

}



