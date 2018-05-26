package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/maximum-absolute-difference-between-sum-of-two-contiguous-sub-arrays/
 */
public class TwoContiguousArray {

	public static void main(String[] args) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = arr.length;
		System.out.println(getMaxAbsDiff(arr, n));
	}

	public static int getMaxAbsDiff(int[] arr, int n) {
		int leftMax[] = new int[n];
		getMaxLeftToRight(arr, n, leftMax);
		
		int rightMax[] = new int[n];
		getMaxRightToLeft(arr, n, rightMax);

		// Invert the array so that we can find min sum 
		int inverted[] = new int[n];
		for (int i = 0; i < n; i++)
			inverted[i] = -arr[i];
		
		//	Get min sum for left of i
		int leftMin[] = new int[n];
		getMaxLeftToRight(inverted, n, leftMin);
		for (int i = 0; i < n; i++)
			leftMin[i] = -leftMin[i];

		// Get minimum sum for right of i
		int rightMin[] = new int[n];
		getMaxRightToLeft(inverted, n, rightMin);
		for (int i = 0; i < n; i++)
			rightMin[i] = -rightMin[i];

		// Get the max absolute difference
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < n-1; i++) {
			maxDiff = Math.max(
					maxDiff,
					Math.max(Math.abs(leftMax[i] - rightMin[i + 1]),
							Math.abs(leftMin[i] - rightMax[i + 1])));
		}
		return maxDiff;

	}

	public static void getMaxLeftToRight(int[] arr, int n, int [] leftMax) {
		int curSum = arr[0], maxSum = arr[0];
		for (int i = 1; i < n; i++) {
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(curSum, maxSum);
			leftMax[i] = maxSum;
		}
	}

	public static void getMaxRightToLeft(int[] arr, int n, int [] rightMax) {
		int curSum = arr[n - 1], maxSum = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(curSum, maxSum);
			rightMax[i] = maxSum;
		}
	}

}
