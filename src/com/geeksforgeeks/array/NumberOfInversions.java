package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/counting-inversions/
 */

public class NumberOfInversions {

	public static void main(String[] args) {
		// int arr[] = { 1, 20, 6, 4, 5 };
		int[] arr = { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282,
				328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293,
				383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300,
				36, 395, 204, 312, 323 };
		int n = arr.length;
		int temp[] = new int[n];
		System.out.println(mergeSort(arr, temp, 0, n - 1));
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}

	public static int mergeSort(int[] arr, int[] temp, int low, int high) {
		int inversion = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			inversion = mergeSort(arr, temp, low, mid);
			inversion += mergeSort(arr, temp, mid + 1, high);
			inversion += merge(arr, temp, low, mid + 1, high);
		}
		return inversion;
	}

	private static int merge(int[] arr, int[] temp, int low, int mid, int high) {
		int inversions = 0;

		// Calculate length of right and left subtree
		int i = low;
		int j = mid;
		int k = low;

		while ((i <= mid - 1) && j <= high) {
			if (arr[i] > arr[j]) {
				temp[k++] = arr[j++];
				inversions += (mid - i);
			}

			else
				temp[k++] = arr[i++];
		}

		// For the remaining elements in either arr1 or arr2
		while (i <= (mid - 1)) {
			temp[k++] = arr[i++];
		}

		while (j <= high)
			temp[k++] = arr[j++];

		// Copy the array temporary[] back to the original array
		for (i = low; i <= high; i++)
			arr[i] = temp[i];

		return inversions;
	}
}
