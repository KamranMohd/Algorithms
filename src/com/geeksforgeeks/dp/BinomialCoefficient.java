package com.geeksforgeeks.dp;

/*
 * WAP to print binomial coefficient
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 */

public class BinomialCoefficient {
	public static void main(String[] args) {
		System.out.println(binomial(5,2));
	}
	public static int binomial(int n,int k){
		int num=1,den=1;
		for(int i=0;i<k;i++)
			num*=(n-i);
		for(int j=k;j>=1;j--)
			den*=j;
		return num/den;
	}
}
