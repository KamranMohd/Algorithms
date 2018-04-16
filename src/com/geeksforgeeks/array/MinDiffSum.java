package com.geeksforgeeks.array;

public class MinDiffSum {

	public static void main(String[] args) {
		//int [] arr = {10, 22, 28, 29, 30, 40};
		int [] arr = {10, 22, 28, 29, 30, 40};
		//int sum = 54;
		int sum = 15;
		getMinDiffSum(arr, 0, arr.length-1, sum);
	}

	public static void getMinDiffSum(int [] arr, int low,int high,int sum){
		int min_diff = Integer.MAX_VALUE,i=0,j=0;
		if(high>low){
			if(Math.abs(arr[low] + arr[high] - sum) < min_diff){
				min_diff = Math.abs(arr[low] + arr[high] - sum);
				i = low;
				j = high;
			}
			else if(arr[low] + arr[high] > sum)
				high--;
			else
				low++;
		}
		System.out.println("Pair : (" + arr[i] + " , " + arr[j] + ")");
	}
}