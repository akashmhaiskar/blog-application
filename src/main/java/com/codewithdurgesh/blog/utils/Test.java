package com.codewithdurgesh.blog.utils;

import java.util.Scanner;

public class Test {

	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number- ");
		int inputNumber = in.nextInt();
		if(inputNumber < 0) {
			System.out.println("Incorrect number");
			System.exit(inputNumber);
		}
		int sum = 0;
		for(int i=1; i<= inputNumber;i++) {
			int factorial = getFactorial(i);
			sum += factorial;
						
		}
		System.out.println(sum);
		
		
		
	}

	private static int getFactorial(int number) {
		int fact = 1;
		for(int i = 1; i <= number; i++ ) {
			fact = fact*i;
		}
		return fact;		
	}
}
