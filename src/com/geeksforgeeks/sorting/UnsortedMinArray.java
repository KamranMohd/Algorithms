package com.geeksforgeeks.sorting;

public class UnsortedMinArray {

	public static void main(String[] args) {
		//int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int arr[] = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		getUnsorted(arr);
	}

	public static void getUnsorted(int [] arr){
		int low=0,high=arr.length-1;
		while(low<high && arr[low] < arr[low+1])
			low++;
		while(high>0 && arr[high] > arr[high-1])
			high--;
		int min = getMin(arr,low,high);
		int max = getMax(arr,low,high);
		while(low > 0 && arr[low-1] > min)
			low--;
		while(high < (arr.length-1) && arr[high+1] < max)
			high++;
		System.out.println("Starting Index : " + low + " End Index : " + high);
	}

	private static int getMin(int[] arr, int low, int high) {
		int min = arr[low];
		for(int i=low+1;i<=high;i++){
			if(arr[i]<min)
				min = arr[i];
		}
		return min;
	}

	private static int getMax(int[] arr, int low, int high) {
		int max = arr[low];
		for(int i=low+1;i<=high;i++){
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}
}
