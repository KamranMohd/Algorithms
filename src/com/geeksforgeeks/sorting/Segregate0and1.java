package com.geeksforgeeks.sorting;

/*
 * You are given an array of 0s and 1s in random order. 
 * Segregate 0s on left side and 1s on right side of the array.
 * 
 */
public class Segregate0and1 {
	public static void main(String[] args) {
		int [] arr = {0, 1, 0, 1, 1, 1};
		doSegregation(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static void doSegregation(int [] arr){
		int low = 0,high = arr.length-1;
		while(low<high){
			while(low<high && arr[low]==0)
				low++;
			while(high > low && arr[high]==1)
				high--;
			if(low < high){
				arr[low] = 0;
				arr[high] = 1;
				low++;
				high--;
			}
		}
	}
}