package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * https://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/ : This problem is an extension of 
 * the subset sum problem 
 * https://www.geeksforgeeks.org/subset-sum-problem-osum-space/
 */
public class SumSubsetProblem {

	public static void main(String[] args) {
		//int arr[] = {3, 34, 4, 12, 5, 2}, total = 9;
		//int arr[] = {4, 1, 10, 12, 5, 2}, total = 9;
		int arr[] = { 1, 8, 2, 5 }, total = 4;
		System.out.println("Is subset present recusion: "
				+ isSubset(arr, total, arr.length - 1));
		System.out.println("Is subset present DP : "
				+ isSubsetDP(arr, total, arr.length));
	}

	/*
	 * Method 1 : Recursive solution to the problem
	 */
	public static boolean isSubset(int[] arr, int total, int i) {
		// Base case 1: If total is 0, we have a subset with sum 0 i.e. empty
		// subset
		if (total == 0)
			return true;

		// Base 2 : If total is less than 0
		if (total < 0)
			return false;

		// Base 3 : If no element is left to be considered
		if (i < 0)
			return false;

		// If the current element is greater than total,
		// then we can't include it in the subset
		if (arr[i] > total)
			return isSubset(arr, total, i - 1);

		// For other elements, we can either a) include it or b)exclude them
		return isSubset(arr, total - arr[i], i - 1)
				|| isSubset(arr, total, i - 1);
	}

	/*
	 * Method 2: Dynamic Programming
	 */

	public static boolean isSubsetDP(int arr[], int total, int n) {
		// Create a dp[][], where dp[i][j]=true, if there is a subset
		// from arr[0..j-1] that can create the total i
		boolean dp[][] = new boolean[total + 1][n + 1];

		// If the sum if zero, then there is always a subset that
		// can produce 0, which is {}
		for (int i = 0; i <= n; i++)
			dp[0][i] = true;

		// If the subset is empty and the sum is gt > 0, then
		// there is no subset that produces the desired output
		for (int i = 1; i <= total; i++)
			dp[i][0] = false;

		// Loop for all the sum
		for (int i = 1; i <= total; i++) {
			// consider each array index
			for (int j = 1; j <= n; j++) {
				// if the current element is greater than total, then
				// the desired subset can't include this element
				if (arr[j - 1] > i)
					dp[i][j] = dp[i][j-1];

				else
					// If not we can either consider it or not consider it
					dp[i][j] = dp[i - arr[j - 1]][j - 1] || dp[i][j - 1];
			}
		}

		return dp[total][n];
	}

}
