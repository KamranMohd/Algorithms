package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		//int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		//int arr[]   = {2, 0, 2};
		int arr[]   = {3, 0, 0, 2, 0, 4};
		int n = arr.length;
		getTrappedWater(arr, n);
		getTrappedWaterOpt(arr, n);
	}

	/*
	 * Time complexity : O(n) Space complexity : O(n)
	 */
	public static void getTrappedWater(int[] arr, int n) {
		// Create 2 arrays to hold highest pole size
		// upto index i on both left and right side
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++)
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);

		rightMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);

		int water = 0;
		for (int i = 0; i < n; i++)
			water += Math.min(rightMax[i], leftMax[i]) - arr[i];
		System.out.println("total water stored : " + water);
	}

	/*
	 * Time complexity : O(n) Space complexity : O(1)
	 */
	public static void getTrappedWaterOpt(int[] arr, int n) {
		int leftMax = 0, rightMax = 0, water = 0;
		int low = 0, high = n - 1;
		while (low <= high) {
			// If arr[low] < arr[high], then the water that can be trapped
			// completely depends on the highest pole on the left hand side
			if (arr[low] < arr[high]) {
				if (arr[low] > leftMax)
					leftMax = arr[low];
				else
					water += leftMax - arr[low];
				low++;
			}
			// If arr[high] > arr[high], then the water that can be trapped
			// completely depends on the highest pole on the right hand side
			else {
				if (arr[high] > rightMax)
					rightMax = arr[high];
				else
					water += rightMax - arr[high];
				high--;
			}
		}
		System.out.println("total water stored : " + water);
	}

}
