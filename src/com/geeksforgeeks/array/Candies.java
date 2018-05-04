package com.geeksforgeeks.array;

/*
 * https://www.hackerrank.com/challenges/candies/problem
 */

public class Candies {
	public static void main(String[] args) {
		//int arr[] = { 4, 6, 4, 5, 6, 2 };
		int arr[] = {9, 2, 3, 6, 5, 4, 3, 2, 2, 2};
				//  {2, 1, 2, 5, 4, 3, 2, 1, 1, 1} = 22 To prove why values[i] = temp on line 31
		System.out.println(getMinCandies(arr, arr.length));
	}

	public static long getMinCandies(int[] arr, int n) {
		long minCan, temp, values[] = new long[n];
		values[0] = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1])
				values[i] = values[i - 1] + 1;
			else
				values[i] = 1;
		}
		minCan = values[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				temp = values[i + 1] + 1;
			} else
				temp = 1;
			minCan += Math.max(temp, values[i]);
			//values[i] = temp;
		}
		return minCan;
	}
}