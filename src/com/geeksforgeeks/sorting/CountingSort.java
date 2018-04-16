package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int arr[] = {1, 4, 1, 2, 7, 5, 2};
		countingSort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static void countingSort(int [] arr){
		int temp [] = new int[arr.length];
		int count [] = new int[10];
		Arrays.fill(count, 0);
		
		//	Count the frequency of each number
		for(int i=0;i<arr.length;i++)
			count[arr[i]]++;
		//	Calculate cumulative frequency
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		
		//	Create a temporary sorted array
		for(int i=0;i<arr.length;i++){
			temp[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		for(int i=0;i<arr.length;i++)
			arr[i] = temp[i];
	}
}
