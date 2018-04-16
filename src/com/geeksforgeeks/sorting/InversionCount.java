package com.geeksforgeeks.sorting;

public class InversionCount {

	public static void main(String[] args) {
		//int arr[] = {1, 20, 6, 4, 5};
		int arr[] = {2, 4, 1, 3, 5};
		System.out.println("Number of inversions : " + mergeSort(arr, 0, arr.length-1));
	}
	
	public static int mergeSort(int [] arr, int low,int high){
		int inversions = 0;
		if(low < high){
			int mid = (high+low)/2;
			inversions = mergeSort(arr, low, mid);
			inversions += mergeSort(arr, mid+1, high);
			inversions += merge(arr, low, mid, high);
		}
		return inversions;
	}

	private static int merge(int[] arr, int low, int mid, int high) {
		int countInv = 0;
		int size1 = mid-low+1;
		int size2 = high-mid;
		int arr1[] = new int[size1];
		int arr2[] = new int[size2];
		for(int i=0;i<size1;i++)
			arr1[i] = arr[low+i];
		for(int i=0;i<size2;i++)
			arr2[i] = arr[mid+1+i];
		
		int i=0,j=0,k=low;
		while(i<size1 && j<size2){
			if(arr1[i]<=arr2[j]){
				arr[k++] = arr1[i++];
			}else{
				arr[k++] = arr2[j++];
				countInv += mid+1-i;
			}
		}
		while(i<size1)
			arr[k++] = arr1[i++];
		while(j<size2)
			arr[k++] = arr2[j++];
		return countInv;
	}
}