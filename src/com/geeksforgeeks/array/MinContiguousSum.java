package com.geeksforgeeks.array;

public class MinContiguousSum {

	public static void main(String[] args) {
		int arr[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
		System.out.println("Min contiguous sum : " + getMinContiguousSum(arr));
	}

	public static int getMinContiguousSum(int[] arr) {
		int inverted[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			inverted[i] = -arr[i];
		int minSum = inverted[0], currentSum = inverted[0];
		for (int i = 1; i < arr.length; i++) {
			currentSum = Math.max(inverted[i], currentSum + inverted[i]);
			minSum = Math.max(currentSum, minSum);
		}
		return -minSum;
	}
}
