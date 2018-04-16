package com.geeksforgeeks.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr [] = {64, 25, 12, 22, 11};
		arr = doInsertionSort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);

	}
	public static int[] doInsertionSort(int [] arr){
		int temp;
		for(int i=1;i<arr.length;i++){
			for(int j=i;j>0;j--){
				if(arr[j]<arr[j-1]){
					//	Swap the 2 elements
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}