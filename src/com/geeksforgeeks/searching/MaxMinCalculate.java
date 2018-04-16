package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 */
class MinMax{
	public int max,min;
}

public class MaxMinCalculate {

	public static void main(String[] args) {
		int arr[] = {1000,11,445,1,330,3000};
		MinMax2 result = getMinMax(arr, 0, arr.length-1);
		System.out.println("Min is : " + result.min + " and Max is : " + result.max);
	}

	public static MinMax2 getMinMax(int arr[],int low, int high){
		MinMax2 result = new MinMax2(),left=null,right=null;
		//	Only one element in the array
		if(low==high){
			result.min = arr[low];
			result.max = arr[low];
			return result;
		}
		
		//	If there are 2 elements in the array
		if(high == low+1){
			if(arr[low] > arr[high]){
				result.min = arr[high];
				result.max = arr[low];
			}
			else{
				result.min = arr[low];
				result.max = arr[high];
			}
			return result;			
		}
		
		// If there are more than 2 elements
		int mid = (low+high)/2;
		left = getMinMax(arr,low,mid);
		right = getMinMax(arr,mid+1,high);
		if(left.min <= right.min)
			result.min = left.min;
		else
			result.min = right.min;
		if(left.max >= right.max)
			result.max = left.max;
		else
			result.max = right.max;
		return result;
	}
}
