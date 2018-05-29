package com.geeksforgeeks.array;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/chocolate-distribution-problem/
 */

public class ChocolateDistributionProblem {

	public static void main(String[] args) {
		// int arr[] = {7, 3, 2, 4, 9, 12, 56};
		// int m = 3;
		int arr[] = { 3, 4, 1, 9, 56, 7, 9, 12 };
		int m = 5;
		getminDiff(arr, arr.length, m);
	}

	public static void getminDiff(int[] arr, int n, int m) {
		//	If one of children or chocolate packets is zero,
		//	then return
		if (n == 0 || m == 0)
			return;
		
		//	Number of students can't be greater than the no of packets
		//	since each students should receive atleast one packet
		if (m > n)
			return;
		Arrays.sort(arr);
		int start = 0, end = 0;
		int minDiff = arr[m - 1] - arr[0];
		for (int i = 1; i < n - m; i++) {
			if (arr[i + m - 1] - arr[i] < minDiff) {
				minDiff = arr[i + m - 1] - arr[i];
				start = i;
				end = i + m - 1;
			}

		}
		System.out.println("Minimum difference : " + minDiff);
		System.out.print("Chocolcates to be given : ");
		for (int i = start; i <= end; i++)
			System.out.print(arr[i] + " ");
	}
}
