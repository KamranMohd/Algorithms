package com.geeksforgeeks.dp;

/*
 * WAP to solve fibonacci series problem using Dynammic Programming + Tabular approach
 * http://www.geeksforgeeks.org/dynamic-programming-set-1/
 */

public class FibonacciTabular {
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
	}
	
	public static int fibonacci(int n){
		int fib[] = new int[n];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2;i<n;i++)
			fib[i] = fib[i-2] + fib[i-1];
		return fib[n-1];
	}
}