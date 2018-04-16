package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 */
class MinMax2{
	public int max,min;
}

public class MaxMinCalculate2 {

	public static void main(String[] args) {
		int arr[] = {1000,11,445,1,330,3000};
		MinMax result = getMinMax(arr);
		System.out.println("Min is : " + result.min + " and Max is : " + result.max);
	}

	public static MinMax getMinMax(int arr[]){
		MinMax result = new MinMax();
		int startingIndex;
		//	If the no of element is even, assign accordingly
		//	Else if the no of element is odd, assign first as min and max
		if(arr.length%2 == 0){
			if(arr[0] > arr[1]){
				result.min = arr[1];
				result.max = arr[0];
			}else{
				result.min = arr[0];
				result.max = arr[1];
			}
			startingIndex = 2;	
		}else{
			result.min = arr[0];
			result.max = arr[0];
			startingIndex = 1;
		}
		for(int i=startingIndex;i<arr.length-2;i=i+2){
			if(arr[i] > arr[i+1]){
				if(result.min > arr[i+1])
					result.min = arr[i+1];
				if(result.max < arr[i])
					result.max = arr[i];
			}
			else{
				if(result.max <= arr[i+1])
					result.max = arr[i+1];
				if(result.min > arr[i])
					result.min = arr[i];
			}
			System.out.println(i);
		}
		return result;
	}
}
