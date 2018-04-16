package com.geeksforgeeks.searching;

/*
 * Find first occurence of a number in Log(n) in sorted array
 */
public class FirstOccurenceBinarySearch {

	public static void main(String[] args) {
		int arr[] = {1,1,2,2,3,3,3,3,4,4,4,4};
		System.out.println("First Index : " + firstOccurence(arr, 0, arr.length-1, 4));
	}
	
	public static int firstOccurence(int [] arr,int low,int high,int toSearch){
		if(high>=low){
			int mid = low + (high-low)/2;
			if((mid==0 || toSearch > arr[mid-1]) && arr[mid]==toSearch){
				return mid;
			}else if(toSearch > arr[mid]){
				return firstOccurence(arr, mid+1, high, toSearch);
			}else{
				return firstOccurence(arr, low, mid-1, toSearch);
			}
		}
		return -1;
	}
}