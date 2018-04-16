package com.geeksforgeeks.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
 */
public class GivenDifference {
	public static void main(String[] args) {
	//	int arr[] = {5, 20, 3, 2, 50, 80,100,22};
	//	int arr[] = {90, 70, 20, 80, 50};
	//	int arr[] = {1, 8, 30, 40, 100};
		//int diff = 78;
		//int diff = 45;
		int arr [] = {1 ,5 ,4 ,1, 2};
		Arrays.sort(arr);
		int diff = 0;
		getPair(arr,diff);
	}
	public static void getPair(int [] arr,int diff){
		int toSearch;
		for(int i=0;i<arr.length;i++){
			toSearch = arr[i] + diff;
			if(binarySearch(arr,toSearch,i+1,arr.length-1)!=-1)
				System.out.println("(" + arr[i] + "," + toSearch + ")");
		}
	}
	private static int binarySearch(int[] arr, int toSearch,int low,int high) {
		if(low > high)
			return -1;
		int mid = (low+high)/2;
		if(arr[mid]==toSearch)
			return mid;
		else if(arr[mid] < toSearch)
			return binarySearch(arr, toSearch, mid+1, high);
		else
			return binarySearch(arr, toSearch, low, mid-1);
	}
}