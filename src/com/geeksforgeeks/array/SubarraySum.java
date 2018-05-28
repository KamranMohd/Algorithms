package com.geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

	public static void main(String[] args) {
		//int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		//int sum = 23;
		int arr[] = {10, 2, -2, -20, 10};
		int sum = -10;
		//printSubarraySum(arr, arr.length, sum);
		printSubarraySum2(arr, arr.length, sum);
	}

	/*
	 * Method 1: This method does not handle negative numbers
	 */
	public static void printSubarraySum(int[] arr, int n, int sum) {
		int curSum = 0, startIndex = 0;
		for (int i = 0; i < n; i++) {
			curSum += arr[i];
			if (curSum == sum) {
				System.out.println("Subarray between index : " + startIndex
						+ " to " + i);
				return;
			}
			while (curSum > sum) {
				curSum -= arr[startIndex];
				startIndex++;
			}
		}
		System.out.println("No such subarray found");
	}

	/*
	 * Method 2: This method handles negative numbers
	 */
	public static void printSubarraySum2(int[] arr, int n, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		int curSum = 0;
		for (int i = 0; i < n; i++) {
			curSum += arr[i];
			if (curSum == sum) {
				System.out.println("Subarray found between : 0 to " + i);
				return;
			}
			if (map.get(curSum - sum) != null) {
				System.out.println("Subarray found between : "
						+ (map.get(curSum - sum) + 1) + " to " + i);
				return;
			}
			map.put(curSum, i);
		}
		System.out.println("No such subarray found.");
	}
}
