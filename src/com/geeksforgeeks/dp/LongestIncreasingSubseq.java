package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/longest-increasing-subsequence/
 */

public class LongestIncreasingSubseq {

	public static void main(String[] args) {
		//int arr[] = {3, 10, 2, 1, 20};
		//int arr[] = {3, 2};
		//nt arr[] = {50, 3, 10, 7, 40, 80};
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("LIS is : " + getMaxSubseq(arr));
	}
	
	public static int getMaxSubseq(int [] arr){
		int n = arr.length;
		int dp[] = new int[n];
		
		//	Initializing the value with 1 for all index
		for(int i=0;i<n;i++)
			dp[i] = 1;
		
		//	Compare each index with all previous index and update
		//	the values
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j] + 1;
			}
		}
		
		//	Find the maximum value and return
		int result = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(dp[i] > result)
				result = dp[i];
		}
		
		return result;
	}
}
