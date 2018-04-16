package com.geeksforgeeks.sorting;

/*
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */

public class DutchNationalFlag {
	public static void main(String[] args) {
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sort012(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	public static void sort012(int [] arr){
		int low=0,mid=0,high=arr.length-1,temp;
		while(mid<=high){
			if(arr[mid]==0){
				temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;mid++;
			}
			else if(arr[mid]==1){
				mid++;
			}
			else if(arr[mid]==2){
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
			}
		}
	}
}