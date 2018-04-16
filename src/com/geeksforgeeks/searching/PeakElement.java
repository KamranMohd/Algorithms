package com.geeksforgeeks.searching;
/*
 * http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * References:
 *	http://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf
 *	http://www.youtube.com/watch?v=HtSuA80QTyo
 */
public class PeakElement {

	public static void main(String[] args) {
		//int arr[] = {5, 10, 20, 15};
		//int arr[] = {10, 20, 15, 2, 23, 90, 67};
		//int arr[] = {10, 20, 30, 40, 50};
		//int arr[] = {100, 80, 60, 50, 20};
		//int arr[] = {12,12,12,12};
		int arr[] = {1, 3, 20, 4, 1, 0};
		System.out.println(getPeakElement(arr, 0, arr.length-1));
	}
	public static int getPeakElement(int [] arr,int low, int high){
		if(high<low)
			return -1;
		if(high==low+1 && arr[high]>=arr[low])
			return arr[high];
		if(high==low+1 && arr[high]<=arr[low])
			return arr[low];
		int mid = (low+high)/2;
		if(arr[mid]>=arr[mid+1] && arr[mid]>=arr[mid-1])
			return arr[mid];
		if(arr[mid] < arr[mid+1])
			return getPeakElement(arr, mid+1, high);
		return getPeakElement(arr, low, mid-1);
	}
}