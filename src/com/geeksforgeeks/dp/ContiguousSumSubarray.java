package com.geeksforgeeks.dp;

/*
 * Write an efficient C program to find the sum of contiguous subarray 
 * within a one-dimensional array of numbers which has the largest sum
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class ContiguousSumSubarray {

	public static void main(String[] args) {
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(largestSum(arr, 0, arr.length-1));
	}
	
	public static int largestSum(int [] arr,int low,int high){
		int sum_max = summation(arr,low,high),sum_temp = 0;
		while(low<high){
			if(summation(arr,low+1,high)>summation(arr, low, high-1)){
				low++;
				sum_temp = summation(arr,low+1,high);
			}else{
				high--;
				sum_temp = summation(arr,low,high-1);
			}
			if(sum_temp>sum_max)
				sum_max = sum_temp;
		}
		return sum_max;
	}
	public static int summation(int [] arr, int low,int high){
		int sum = 0;
		for(int i=low;i<=high;i++)
			sum+=arr[i];
		return sum;
	}

}
