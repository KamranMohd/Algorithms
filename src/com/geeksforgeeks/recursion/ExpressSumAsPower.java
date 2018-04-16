package com.geeksforgeeks.recursion;

/*
 * Given two integers x and n, 
 * we need to find number of ways to express x as sum of n-th powers of unique natural numbers. 
 * It is given that 1 <= n <= 20.
 * http://www.geeksforgeeks.org/count-ways-express-number-sum-powers/
 * 
 */

public class ExpressSumAsPower {

	public static void main(String[] args) {
		int number = 100;
		int n = 2;
		int count = countWays(number,n,1);
		System.out.println(count);
	}
	
	public static int countWays(int number, int n, int currentNatNo){
		int remainder = (int)(number-Math.pow(currentNatNo,n));
		if(remainder==0)
			return 1;
		if(remainder<0)
			return 0;
		return (countWays(number, n, currentNatNo+1) + countWays(remainder, n, currentNatNo+1));
	}

}
