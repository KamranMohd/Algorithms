package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 */
public class FixedIndex {

	public static void main(String[] args) {
		//int arr[] = {-10, -5, 0, 3, 7};
		//int arr[] = {0, 2, 5, 8, 17};
		int arr[] = {-10, -5, 3, 4, 7, 9};
		System.out.println(getFixedPoint(arr, 0, arr.length-1));
	}
	public static int getFixedPoint(int [] arr,int low,int high){
		if(high < low)
			return -1;
		int mid = (low+high)/2;
		if(low<high && arr[mid]==mid)
			return mid;
		if(arr[mid] < mid)
			return getFixedPoint(arr, mid+1, high);
		return getFixedPoint(arr, low, mid-1);
	}
}