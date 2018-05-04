package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/maximum-product-subarray/
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {
		// int arr[] = {1, -2, -3, 0, 7, -8, -2};
		// int arr[] = { 6, -3, -10, 0, -2 };
		// int arr[] = { 0, 0, -20, 0 };
		// int arr[] = {-1, -3, -10, 0, 60};
		// int arr[] = {0,0,0,1};
		// int arr[] = { 0, 0, 0, -20 };
		// int arr[] = {-1,2,3,-4,-6};
		int arr[] = {-20};
		// int[] arr = { 0, -1 };
		//int arr[] = {-1, -1};
		// int arr[] = {-2, -3, 0, -2, -40};
		System.out.println("Maximum sub product : " + maxProductArr(arr));
	}

	public static int maxProductArr(int[] arr) {
		if (arr.length == 1 && arr[0] <= 0)
			return arr[0];
		int currentMax = 1, currentMin = 1, max = arr[0];
		boolean isPositivePresent = false, isPresentZero = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				isPositivePresent = true;
				currentMax *= arr[i];
				currentMin = Math.min(currentMin * arr[i], 1);
			} else if (arr[i] == 0) {
				isPresentZero = true;
				currentMax = 1;
				currentMin = 1;
			} else {
				int temp = currentMax;
				currentMax = Math.max(currentMin * arr[i], 1);
				currentMin = arr[i] * temp;
			}
			if (max < currentMax)
				max = currentMax;
		}
		return ((isPositivePresent == false && isPresentZero==true && max == 1) ? 0 : max);
	}

}
