package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
public class MinimumJumps {

	public static void main(String[] args) {
		// int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		// int arr[] = {1, 3, 6, 1, 0, 9};
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(minJumps(arr, 0, arr.length - 1));
		System.out.println(minJumpsDp(arr,arr.length));
	}

	/*
	 * Method 1 : Recursive approach
	 */
	public static int minJumps(int[] arr, int l, int h) {
		if (l == h)
			return 0;
		if (arr[l] == 0)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int jumps = minJumps(arr, i, h);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}
		return min;
	}

	/*
	 * Method 2: Using Dynamic Programming
	 */

	public static int minJumpsDp(int arr[], int n) {
		int[] jumps = new int[n];
		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;
		jumps[0] = 0;
		for (int i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= (j + arr[j]) && jumps[j] != Integer.MAX_VALUE)
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
			}
		}
		return jumps[n - 1];
	}

}
