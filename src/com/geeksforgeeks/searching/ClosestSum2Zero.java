package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
 */

import java.util.Arrays;

public class ClosestSum2Zero {

	public static void main(String[] args) {
		int arr[] = {1, 60, -10, 70, -80, 85};
		Arrays.sort(arr);
		findClosestSumToZero(arr);
	}

	public static void findClosestSumToZero(int [] arr){
		int low=0,high=arr.length-1,ind1=-1,ind2=-1,min_sum=999999,sum=0;
		while(low<high){
			sum = arr[low] + arr[high];
			if(Math.abs(sum) < min_sum){
				min_sum = Math.abs(sum);
				ind1 = low;
				ind2 = high;
			}
			if(sum >= 0)
				high--;
			else
				low++;
		}
		System.out.println("Pair is (" + arr[ind1] + "," + arr[ind2] + "). Sum is " + min_sum);
	}
}