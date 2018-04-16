package com.geeksforgeeks.dp;

/*
 * Write an efficient C program to find the sum of contiguous subarray 
 * within a one-dimensional array of numbers which has the largest sum
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */

public class ContinousSumSubarrayEff {
	public static void main(String[] args) {
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		//int arr[] = {-13, -3, -25, -20, -3, -16, -23, -12, -5, -22, -15, -4, -7};
		//System.out.println(kadaneAlgo(arr));
		System.out.println(usingDynamic(arr));
	}
	
	public static int kadaneAlgo(int arr[]){
		int sum_max=-9999,sum_so_far=-99999;
		for(int i=0;i<=arr.length-1;i++){
			sum_so_far += arr[i];
			if(sum_so_far>sum_max)
				sum_max = sum_so_far;
			if(sum_so_far<0)
				sum_so_far = 0;
		}
		return sum_max;
	}
	
	public static int usingDynamic(int arr[]){
		int current_max=arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++){
			current_max = Math.max(arr[i],current_max+arr[i]);
			max = Math.max(max, current_max);
		}
		return max;
	}
}
