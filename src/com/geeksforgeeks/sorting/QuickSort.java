package com.geeksforgeeks.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int arr [] = {64, 25, 12, 22, 11};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static void quickSort(int [] arr,int low,int high){
		if(low < high){
			int partitionIndex = partition(arr,low,high);
			quickSort(arr,low,partitionIndex-1);
			quickSort(arr,partitionIndex+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i=low,temp;
		while(low<high){
			if(arr[low] < pivot){
				//	Swap arr[low] with ith index element
				temp = arr[low];
				arr[low] = arr[i];
				arr[i] = temp;
				i++;
			}
			low++;
		}
		//	Swap pivot with the ith element
		temp = arr[high];
		arr[high] = arr[i];
		arr[i] = temp;
		return i;
	}
}