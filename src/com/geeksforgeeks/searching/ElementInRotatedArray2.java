package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */

public class ElementInRotatedArray2 {

	public static void main(String[] args) {
		//int arr[] = {3,4,5,1,2};
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		//int arr[] = {5, 6, 7, 8, 9, 10};
		int toSearch = 3;
		System.out.println(findElement(arr, 0, arr.length-1,toSearch));
	}
	public static int findElement(int [] arr,int low,int high,int toSearch){
		if(low>high)
			return -1;
		int mid = (low+high)/2;
		if(toSearch==arr[mid])
			return mid;
		//	On splitting the array in half, one half will be sorted and the other will be rotated
		//	Check if left subarray is sorted
		if(arr[low]<=arr[mid]){
			if(toSearch>=arr[low] && toSearch<=arr[mid])
				return findElement(arr, low, mid, toSearch);
			return findElement(arr, mid+1, high, toSearch);
		}
		//	If left subarray is not sorted, then right subarray is sorted
		else{
			if(toSearch>=arr[mid+1] && toSearch<=arr[high])
				return findElement(arr, mid+1, high, toSearch);
			return findElement(arr, low, mid+1, toSearch);
		}
	}
}