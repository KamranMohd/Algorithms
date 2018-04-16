package com.geeksforgeeks.recursion;

/*
 * WAP to print binomial coefficient
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 */

public class BinomialCoefficient {
	public static void main(String[] args) {
		System.out.println(binomialCoe(5, 2));
	}
	
	public static int binomialCoe(int n,int k){
		//	Base case
		if(k==0 || n==k)
			return 1;
		else
			return (binomialCoe(n-1,k-1) + binomialCoe(n-1,k));
	}
}
