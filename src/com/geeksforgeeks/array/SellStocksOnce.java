package com.geeksforgeeks.array;

/*
 * Variation : https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class SellStocksOnce {

	public static void main(String[] args) {
		int arr [] = {2, 3, 10, 6, 4, 8, 1};
		//int [] arr = {7, 9, 5, 6, 3, 2};
		System.out.println(getMaxProfit(arr));
		System.out.println(getMaxProfit2(arr));
	}
	
	/*
	 * Method 1: Keep track of min value and max difference
	 */
	public static int getMaxProfit(int [] arr){
		int n = arr.length;
		int min = arr[0];
		int maxDiff = arr[1] - arr[0];
		for(int i=1;i<n;i++){
			if(arr[i] < min)
				min = arr[i];
			maxDiff = Math.max(maxDiff,arr[i]-min);
		}
		return maxDiff;
	}
	
	/*
	 * Method 2: Get the difference array and then find the max subarray sum
	 */
	public static int getMaxProfit2(int [] arr){
		//	Get diff array
		int diff[] = new int[arr.length-1];
		for(int i=0;i<arr.length-1;i++)
			diff[i] = arr[i+1] - arr[i];
		int current_sum = diff[0], max_sum = diff[0];
		for(int i=1;i<diff.length;i++){
			current_sum = Math.max(diff[i], diff[i] + current_sum);
			max_sum = Math.max(max_sum, current_sum);
		}
		return max_sum;
	}

}
