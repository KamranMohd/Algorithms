package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class ElementInRotatedArray {

	public static void main(String[] args) {
		int arr[] = {3,4,5,1,2};
		//int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		//int arr[] = {5, 6, 7, 8, 9, 10};
		int toSearch = 1;
		System.out.println(findElement(arr, 0, arr.length-1,toSearch));
	}
	public static int findElement(int [] arr,int low,int high,int toSearch){
		int pivot = findPivot(arr, low, high);
		if(toSearch == arr[pivot])
			return pivot;
		if(toSearch > arr[low])
			high = pivot;
		else
			low = pivot;
		while(low <= high){
			int mid = (low+high)/2;
			if(toSearch==arr[mid])
				return mid;
			if(toSearch > arr[mid])
				low = mid + 1;
			else 
				high = mid - 1;
		}
		return -1;
	}
	public static int findPivot(int [] arr,int low, int high){
		if(low>high)
			return -1;
		if(low==high)
			return low;
		int mid = (low+high)/2;
		if(arr[mid] > arr[mid+1])
			return mid;
		if(arr[mid] < arr[mid-1])
			return mid-1;
		if(arr[low] <= arr[mid])
			return findPivot(arr, mid+1, high);
		return findPivot(arr, low, mid-1);
	}
}