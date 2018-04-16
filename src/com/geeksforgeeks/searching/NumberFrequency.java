package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 */
public class NumberFrequency {

	public static void main(String[] args) {
		int arr[] = {1, 1, 2, 2, 2, 2, 3};
		int x = 2;
		System.out.println(getFrequency(arr, 0, arr.length-1, 0, x));
	}
	public static int getFrequency(int [] arr, int low, int high, int count,int x){
		int mid = (low+high)/2;
		if(low <= high && arr[mid]==x)
			count++;
		if(low < mid && arr[mid-1]>=x)
			count = getFrequency(arr, low, mid-1, count, x);
		if(mid < high && arr[mid+1]<=x)
			count = getFrequency(arr, mid+1, high, count, x);
		return count;
	}
}