package com.geeksforgeeks.array;

public class SlidingWindow {

	public static void main(String[] args) {
		//int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		//int k = 3;
		int k = 4;
		slidingWindow(arr, k);
	}
	public static void slidingWindow(int [] arr, int k){
		//	Find max in window of k size
		int max=Integer.MIN_VALUE;
		for(int i=0;i<k;i++){
			if(arr[i] > max)
				max = arr[i];
		}
		System.out.print(max + " ");
		for(int i=k;i<arr.length;i++){
			if(arr[i] > max)
				max = arr[i];
			System.out.print(max + " ");
		}
	}
}