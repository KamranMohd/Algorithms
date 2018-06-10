package com.geeksforgeeks.array;

public class Temp {

	public static void main(String[] args) {
		int arr[] = { 2, 0, 2, -3, 8, 6, -7, -1, 4 };
		int arr_size = arr.length;
		dutchNationalFlag(arr, arr_size);
		for (int i : arr)
			System.out.print(i + " ");

	}

	public static void dutchNationalFlag(int[] arr, int n) {
		int low = 0, mid = 0, high = n - 1;
		while (mid < high) {
			if (arr[mid] < 0) {
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
			} else if (arr[mid] == 0)
				mid++;
			else {
				int temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
			}
		}
	}

}
