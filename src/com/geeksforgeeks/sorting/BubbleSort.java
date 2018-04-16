package com.geeksforgeeks.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr [] = {64, 25, 12, 22, 11};
		arr = bubbleSort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static int[] bubbleSort(int arr[]){
		int temp;
		boolean swapped;
		for(int i=0;i<arr.length-1;i++){
			swapped = false;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j+1] < arr[j]){
					//	Swap the elements
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if(swapped==false)
				return arr;
		}
		return arr;
	}
}