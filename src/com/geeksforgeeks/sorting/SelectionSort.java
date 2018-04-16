package com.geeksforgeeks.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr [] = {64, 25, 12, 22, 11};
		int min = 0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i;j<arr.length;j++){
				if(arr[j]<=arr[min])
					min = j;
			}
			//	Swap the minimum with the ith index element
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
}