package com.cg;
//instead of having interface implementation in another 
//class we can have it in the same
interface MyInterface{
	void myMethod();
}

public class AppRunner {

	public static void main(String[] args) {
//		MyInterface obj=new MyInterface() {
//		
//			public void myMethod(){
//				System.out.println("My method called");
//			}
//		};
		
		MyInterface obj=()->System.out.println("My method called");
		
		obj.myMethod();
	}

}
