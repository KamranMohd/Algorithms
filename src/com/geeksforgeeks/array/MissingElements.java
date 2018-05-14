package com.geeksforgeeks.array;

/*
 * Finding duplicates in an array containing elements from 0 to n-1
 * https://www.geeksforgeeks.org/?p=9755
 */
public class MissingElements {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 3, 6, 6};
		printDuplicates(arr, arr.length);
	}

	public static void printDuplicates(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if(arr[Math.abs(arr[i])]>=0){
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
			else
				System.out.print(Math.abs(arr[i]) +  " ");
		}
	}
}