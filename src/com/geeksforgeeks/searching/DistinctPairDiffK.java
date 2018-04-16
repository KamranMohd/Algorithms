package com.geeksforgeeks.searching;

import java.util.Arrays;

public class DistinctPairDiffK {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		System.out.println(countPairsWithDiffK(arr, 0));
	}
	public static int countPairsWithDiffK(int arr[],int k)
	{
		Arrays.sort(arr);
		int count=0,left=0,right=0;
		while(left<arr.length && right<arr.length){
			if(arr[right]-arr[left]==k){
				count++;
				left++;
				right++;
				if(k==0){
					while(left < arr.length && right< arr.length && arr[left]==arr[right]){
						right++;
						left++;
					}
				}
			}else if(arr[right]-arr[left] > k)
				left++;
			else
				right++;		
		}
		return count;
	}
}