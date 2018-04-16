package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 */
public class MaximumValue {
	public static void main(String[] args) {
		//int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		//int arr[] = {1, 3, 50, 10, 9, 7, 6};
		//int arr[] = {10, 20, 30, 40, 50};
		int arr[] = {120, 100, 80, 20, 0};
		System.out.println(getMaximum(arr, 0, arr.length-1));
	}

	public static int getMaximum(int arr[],int low,int high){
		if(low>high)
			return -1;
		int mid = (low+high)/2;
		if(mid < high && mid > low && arr[mid]>arr[mid+1] && arr[mid] > arr[mid-1])
			return arr[mid];
		if(mid > high && arr[mid]<arr[mid+1])
			return getMaximum(arr, mid+1, high);
		return getMaximum(arr, low, mid-1);
	}
}