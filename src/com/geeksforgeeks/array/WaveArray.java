package com.geeksforgeeks.array;

/*
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 */
public class WaveArray {

	public static void main(String[] args) {
		//int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		//int arr[] = {5, 7, 3 ,2 ,8};
		int arr[] = {29,9,13,15,6};
		doWaveSort(arr);
		for(int num : arr)
			System.out.print(num + " ");
	}
	
	public static void doWaveSort(int [] arr){
		if(arr.length==1)
			return;
		for(int i=0;i<arr.length;i+=2){
			if((i-1)>=0 && arr[i-1] > arr[i]){
				swap(arr, i-1, i);
			}
			if((i+1) < arr.length && arr[i+1] > arr[i]){
				swap(arr, i, i+1);
			}
		}
	}
	public static void swap(int [] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}