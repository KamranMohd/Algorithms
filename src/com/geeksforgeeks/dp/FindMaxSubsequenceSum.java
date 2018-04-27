package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */

public class FindMaxSubsequenceSum {

	public static void main(String[] args) {
		//int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int a[] = {-2, -3, -4, -1, -2, -1, -5, -3, 0};
		findLargestSum(a);
	}

	private static void findLargestSum(int[] a) {
		int M[] = new int[a.length];
		M[0] = a[0];
		int maxSum = a[0];
		for(int i=1;i<a.length;i++){
			M[i] = Math.max(M[i-1] + a[i], a[i]);
			maxSum = maxSum > M[i] ? maxSum : M[i];
		}
		System.out.println("Maximum contiguous sum is : " + maxSum);
	}
}
