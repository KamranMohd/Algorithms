package com.geeksforgeeks.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr [] = {12 ,11, 13, 5, 6, 7};
		doMergeSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);

	}

	public static void doMergeSort(int arr[],int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			doMergeSort(arr, low, mid);
			doMergeSort(arr, mid+1,high);
			doMerge(arr,low,mid,high);
		}
	}
	public static void doMerge(int arr[], int low,int mid,int high){
		//	Calculate the size of two temporary arrays
		int lSize = mid-low+1;
		int rSize = high-mid;
		//	Create 2 temporary arrays with the above size
		int lArr[] = new int[lSize];
		int rArr[] = new int[rSize];
		
		//	Copy the values of array in temporary arrays
		for(int i=0;i<lSize;i++)
			lArr[i] = arr[i+low];
		for(int j=0;j<rSize;j++)
			rArr[j] = arr[mid+1+j];
		
		//	Do merging of the 2 temporary arrays into original array
		int i=0,j=0,k=low;
		while(i<lSize && j<rSize){
			if(lArr[i]<rArr[j]){
				arr[k] = lArr[i];
				i++;
			}
			else{
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}
		while(i<lSize){
			arr[k] = lArr[i];
			i++;
			k++;
		}
		while(j<rSize){
			arr[k] = rArr[j];
			j++;
			k++;
		}
	}
}
