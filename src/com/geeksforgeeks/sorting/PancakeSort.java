package com.geeksforgeeks.sorting;

/*
 * Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.
 * flip(arr, i): Reverse array from 0 to i 
 * http://www.geeksforgeeks.org/pancake-sorting/
 */
public class PancakeSort {

	public static void main(String[] args) {
		int arr[] = {23, 10, 20, 11, 12, 6, 7};
		doPancakeSort(arr);
		for(int i : arr)
			System.out.println(i);
	}
	
	public static void doPancakeSort(int [] arr){
		int high = arr.length-1;
		while(high >= 2){
			int maxIndex = getMaxIndex(arr,high);
			flip(arr,maxIndex);
			flip(arr,high);
			high--;
		}
	}

	private static void flip(int[] arr, int maxIndex) {
		int low=0,high = maxIndex;
		while(low<high){
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

	private static int getMaxIndex(int[] arr, int high) {
		int max = 0;
		for(int i=1;i<=high;i++){
			if(arr[i] > arr[max])
				max = i;
		}
		return max;
	}
}