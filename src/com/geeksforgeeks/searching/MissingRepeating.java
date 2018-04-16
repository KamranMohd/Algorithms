package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * Time Complexity = O(n)
 * Space complexity = 1
 */

public class MissingRepeating {
	public static void main(String[] args) {
		//int arr[] = {3, 1, 3};
		int arr[] = {4, 3, 6, 2, 1, 1};
		getMissingRepeating(arr);
	}
	public static void getMissingRepeating(int [] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[Math.abs(arr[i])-1]>0)
				arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
			else
				System.out.println("Repeating element = " + -1*arr[i]);
		}
		for(int i=0;i<arr.length;i++)
			if(arr[i]>0)
				System.out.println("Missing element = " + (i+1));
	}
}