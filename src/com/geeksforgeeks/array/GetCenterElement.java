package com.geeksforgeeks.array;

/*
 * Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller 
 * and all right elements to it are greater than it.
 * Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
 * 
 */
public class GetCenterElement {

	public static void main(String[] args) {
		//int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		//int arr[] = {5, 1, 4, 4};
		//int arr[] = {11, 9, 12};
		int arr[] = {4,2,5,7};
		System.out.println(getMidElement(arr));
	}
	public static int getMidElement(int [] arr){
		int len = arr.length;
		int lMax[] = new int[len];
		int rMin[] = new int[len];
		int max = arr[0], min = arr[len-1];
		lMax[0] = Integer.MAX_VALUE;
		rMin[len-1] = Integer.MIN_VALUE;
		for(int i=1;i<len;i++){
			lMax[i] = max;
			if(arr[i]>max)
				max = arr[i];
		}
		for(int i=len-2;i>=0;i--){
			rMin[i] = min;
			if(arr[i] < min)
				min = arr[i];
		}
		int index = -1;
		for(int i=0;i<len;i++){
			if(arr[i] > lMax[i] && arr[i] < rMin[i]){
				index = i;
				break;
			}
		}
		return index;
	}
}