package com.geeksforgeeks.greedy;

/*
 * https://practice.geeksforgeeks.org/problems/minimize-the-heights/0
 */
public class MinHeightDiff {

	public static void main(String[] args) {
		// int[] arr = { 35, 43, 43, 23 };
		// int k = 6;
		// int arr[] = {34,0,19,24,28,8,12,14,5,45,31,27,11,41,45,42,27,36,41};
		// int k = 6;
		// int arr[] = {3, 42, 32, 21, 16, 18, 45, 47};
		// int k = 7;
		int[] arr = { 20, 0, 6, 1 };
		int k = 6;
		System.out.println(minimizeHeightDiff(arr, k, arr.length));
	}

	public static int minimizeHeightDiff(int arr[], int k, int n) {
		//	Find initial max and min heights of the pole
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		// Finding the initial difference between the minimum
		// and max heights of the pole. Initial difference
		int ans = max - min;

		// Subtract k from max and add k to minimum
		int small = min + k;
		int big = max - k;

		// If small becomes greater than big after above operations, swap them
		if (small > big) {
			int temp = big;
			big = small;
			small = temp;
		}

		// Iterate through each element and check for both the cases
		// i. If k is added
		// ii. If k is subtracted
		for (int i = 0; i < n; i++) {
			int add = arr[i] + k;
			int sub = arr[i] - k;

			// If addition and subtraction does not cause any changes,
			// in the maximum and minimum heights, then continue
			if (add <= big || sub >= small)
				continue;

			// Check the height difference for both the cases
			// i. when k is added
			// ii. when k is subtracted
			if (big - sub <= add - small)
				small = sub;
			else
				big = add;
		}

		return Math.min(big - small, ans);
	}
}
