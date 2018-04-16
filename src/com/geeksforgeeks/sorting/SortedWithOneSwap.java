package com.geeksforgeeks.sorting;

public class SortedWithOneSwap {

	public static void main(String[] args) {
		//int arr[] = {10, 20, 60, 40, 50, 30}  ;
		//int arr[] = {10, 20, 40, 30, 50, 60} ;
		int arr[] = {1, 5, 3};
		sort(arr);
		for(int num : arr)
			System.out.print(num + " ");

	}
	
	public static void sort(int [] arr){
		int low = 0,high=arr.length-1;
		while(low<high && arr[low] < arr[low+1])
			low++;
		while(high>0 && arr[high] > arr[high-1])
			high--;
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}