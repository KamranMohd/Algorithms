package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/applications-of-catalan-numbers/
 */
public class BSTCountWithNNodes {

	public static void main(String[] args) {
		int count = getBSTCount(3);
		System.out.println(count);
		getCatalanNumber(6);
	}

	//	Method 1: Recursive approach
	public static int getBSTCount(int n) {
		if (n < 2)
			return 1;
		int count = 0;
		for (int i = 2; i <= n; i++)
			count += getBSTCount(i-1) + getBSTCount(n-i);
		return count;
	}
	
	//Method 2: Iterative approach
	public static void getCatalanNumber(int n){
		int count [] = new int[n+1];
		count[0] = count[1] = 1;
		for(int i=2;i<=n;i++){
			count[i] = 0;
			for(int j=0;j<i;j++){
				count[i] += count[j]*count[i-j-1];
			}
		}
		for(int i : count)
			System.out.print(i + " ");
	}
	
}