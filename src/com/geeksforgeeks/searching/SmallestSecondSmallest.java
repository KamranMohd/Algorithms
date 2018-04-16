package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
 */

public class SmallestSecondSmallest {

	public static void main(String[] args) {
		int arr[] = {12, 13, -1, 10, 34, 10};
		findSmallest(arr);
	}
	public static void findSmallest(int [] arr){
		int min = 99999, secondMin = 9999;
		for(int i=1;i<arr.length;i++){
			if(arr[i] < min)
				min = arr[i];
			else if(arr[i] > min && arr[i] < secondMin)
				secondMin = arr[i];
		}
		System.out.println("Min : " + min + " Second min : " + secondMin);	
	}
}