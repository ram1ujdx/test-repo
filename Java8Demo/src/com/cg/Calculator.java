package com.cg;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathOperations operation=new MathOperations();
		Operator operator=(x,y)->{
			int min=x>y?x:y;
			int gcd=1;
			for(int i=1;i<=min;i++) {
				if(x % i == 0 && y % i == 0) {
					gcd=i;
				}
			}
			return gcd;
		};
	
		int result=operation.calculate(10, 20, operator);
		
		System.out.println("Result = "+result);
	}

}

class MathOperations{
	int calculate(int x, int y, Operator op) {
	return op.operate(x,y);	
	}
}
interface Operator{
	int operate(int x,int y);
}