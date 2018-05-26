package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
 */

public class SumWithNo3Adjacent {

	public static void main(String[] args) {
		//int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		//int a[] = {6, 7, 1, 3, 8, 2, 4};
		//int a[] = {5, 3, 4, 11, 2};
		 int arr[] = {100, 1000, 100, 1000, 1};
		findLargestSum(arr);
	}

	private static void findLargestSum(int[] arr) {
		int sum[] = new int[arr.length];
		sum[0] = arr[0];
		sum[1] = arr[0] + arr[1];
		sum[2] = Math.max(Math.max(arr[2] + sum[0], arr[2] + arr[1]),sum[1]);
		for(int i=3;i<arr.length;i++){
			sum[i] = Math.max(Math.max(arr[i] + sum[i-2], arr[i] + arr[i-1] + sum[i-3]),sum[i-1]);
		}
		System.out.println("Max possible sum : " + sum[arr.length-1]);
	}
}
