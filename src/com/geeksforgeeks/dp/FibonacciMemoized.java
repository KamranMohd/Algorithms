package com.geeksforgeeks.dp;

/*
 * WAP to solve fibonacci series problem using Dynammic Programming + Memoized approach
 * http://www.geeksforgeeks.org/dynamic-programming-set-1/
 */

public class FibonacciMemoized {
	public static int lookup[];
	
	public static void main(String[] args) {
		FibonacciMemoized.initializeLoopUp(6);
		System.out.println(fibonacci(6));
	}
	
	public static void initializeLoopUp(int n){
		FibonacciMemoized.lookup = new int[n];
		for(int i=0;i<n;i++)
			FibonacciMemoized.lookup[i] = -1;
	}
	public static int fibonacci(int n){
		if(n-1>=0 && FibonacciMemoized.lookup[n-1]!=-1)
			return FibonacciMemoized.lookup[n-1];
		else{
			if(n<=1)
				FibonacciMemoized.lookup[n-1] = n;
			else
				FibonacciMemoized.lookup[n-1] = fibonacci(n-1) + fibonacci(n-2);
		}
		return FibonacciMemoized.lookup[n-1];
	}
}
