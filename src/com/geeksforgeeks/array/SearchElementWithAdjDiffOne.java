package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/
 * 
 */
public class SearchElementWithAdjDiffOne {

	public static void main(String[] args) {
		//int arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3} ;
		//int k = 3;
		int arr[] =  {1, 2, 3, 4, 5, 4};
		int k = 5;
		System.out.println("Element found at index : " + getFirstOccurence(arr, 0, arr.length-1, k));
	}
	
	public static int getFirstOccurence(int [] arr, int low, int high, int element){
		int index = 0, diff;
		while(index<=high){
			diff = Math.abs(element - arr[index]);
			if(element == arr[diff+index])
				return diff+index;
			else
				index += diff;
		}
		return -1;
	}
}