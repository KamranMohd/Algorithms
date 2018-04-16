package com.geeksforgeeks.sorting;

public class BubbleSortRecursive {

	public static void main(String[] args) {
		int arr [] = {64, 25, 12, 22, 11};
		arr = bubbleSort(arr,arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static int[] bubbleSort(int arr[],int size){
		int temp;
		if(size==1)
			return arr;
		for(int i=0;i<size-1;i++){
			if(arr[i+1]<arr[i]){
				temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
		}
		return bubbleSort(arr,size-1);
	}
}