package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
 */
public class GtLeftLtRight {

	public static void main(String[] args) {
		// int arr[] = {4, 2, 5, 7};
		int arr[] = { 4, 3, 2, 7, 8, 9 };
		// int arr[] = {11, 9, 12};
		int n = arr.length;
		printMidElement(arr, n);
		printMidElementOpt2(arr, n);
	}

	/*
	 * Method 1 : Using 2 arrays
	 */
	public static void printMidElement(int[] arr, int n) {
		int leftMax[] = new int[n];
		int rightMin[] = new int[n];
		leftMax[0] = arr[0];
		rightMin[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++)
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		for (int i = n - 2; i >= 0; i--)
			rightMin[i] = Math.min(rightMin[i + 1], arr[i]);

		for (int i = 1; i < n - 1; i++) {
			if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) {
				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println(-1);
	}

	/*
	 * Method 2 : Using only 1 array
	 */
	public static void printMidElementOpt(int[] arr, int n) {
		int leftMax[] = new int[n];
		for (int i = 1; i < n; i++)
			leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);

		int rightMin = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] > leftMax[i] && arr[i] < rightMin) {
				System.out.println(arr[i]);
				return;
			}
			rightMin = Math.min(arr[i], rightMin);
		}

		System.out.println(-1);
	}

	/*
	 * Method 3 : Using only 1 array
	 */
	public static void printMidElementOpt2(int[] arr, int n) {
		int rightMin[] = new int[n];
		rightMin[n-1] = arr[n-1];
		for (int i = n - 2; i >= 0; i--)
			rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);

		int leftMax = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > leftMax && arr[i] < rightMin[i]) {
				System.out.println(arr[i]);
				return;
			}

			leftMax = Math.max(arr[i], leftMax);
		}

		System.out.println(-1);
	}
}
