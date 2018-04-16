package com.geeksforgeeks.sorting;

public class InsertionSortRecursively {

	public static void main(String[] args) {
		int arr [] = {64, 25, 12, 22, 11};
		doInsertionSort(arr,arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static void doInsertionSort(int [] arr,int length){
		//	Base Case
		if(length==1)
			return;
		//	Sort first n-1 elements recursively
		doInsertionSort(arr,length-1);
		int last = arr[length-1];
		int swapInd = length-2;
		for(int j=swapInd;j>=0;j--){
			if(arr[j]>last){
				arr[j+1] = arr[j];
				swapInd = j;
			}
		}
		arr[swapInd] = last;
	}
}