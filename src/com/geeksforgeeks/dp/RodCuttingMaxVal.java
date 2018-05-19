package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */

public class RodCuttingMaxVal {
	public static void main(String[] args) {
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("max val using recursion : " + getMaxVal(arr,arr.length));
		System.out.println("max val using dp : " + getMaxValDp(arr, arr.length));
	}

	/*
	 * Method 1: Recursive approach
	 */
	public static int getMaxVal(int [] price, int n){
		if(n<=0)
			return 0;
		int maxVal = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			maxVal = Math.max(maxVal, price[i] + getMaxVal(price, n-(i+1)));
		}
		return maxVal;
	}
	
	/*
	 * Method 2 : Dynamic Programming
	 */
	public static int getMaxValDp(int price[],int n){
		if(n<=0)
			return -1;
		int val [] = new int[n+1];
		val[0] = 0;
		for(int i=1;i<=n;i++){
			int maxVal = Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
				maxVal = Math.max(maxVal, price[j] + val[i-j-1]);
			val[i] = maxVal;
		}
		return val[n];
	}
}
