package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/converting-an-array-of-integers-into-zig-zag-fashion/
 */
public class ZigZagArray {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 7, 8, 6, 2, 1 };
		int n = arr.length;
		System.out.println("Original Array");
		printArr(arr);
		System.out.println("ZigZag Array");
		convertToZigZag(arr, n);
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void convertToZigZag(int[] arr, int n) {
		char comparison = '<';
		for (int i = 0; i < n - 1; i++) {
			if (comparison == '<') {
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);
				comparison = '>';
			} else {
				if (arr[i] < arr[i + 1])
					swap(arr, i, i + 1);
				comparison = '<';
			}
		}
	}

	private static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
