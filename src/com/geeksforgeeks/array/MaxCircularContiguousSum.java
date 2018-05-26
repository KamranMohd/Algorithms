package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */

public class MaxCircularContiguousSum {
	public static void main(String[] args) {
		int arr[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
		System.out.println("Max circular sum : " + getCircularMax(arr));
	} 

	public static int getCircularMax(int arr[]) {
		int n = arr.length;
		// Get maximum contiguous sum without including the corner elements
		int maxCont = getMaxCont(arr, n);
		// Get max contiguous sum if corners are included
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			arr[i] = -arr[i];
		}
		int minCont = getMaxCont(arr, n);
		int maxCorner = sum - (-minCont);
		return Math.max(maxCorner, maxCont);
	}

	public static int getMaxCont(int[] arr, int n) {
		int curSum = arr[0], maxSum = arr[0];
		for (int i = 1; i < n; i++) {
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;
	}

}
