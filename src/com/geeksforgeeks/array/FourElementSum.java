package com.geeksforgeeks.array;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/?p=23327
 */

public class FourElementSum {

	public static void main(String[] args) {
		int arr[] = {1, 4, 45, 6, 10, 12};
		int sum = 21;
		System.out.println("Required Sum : " + isPresent(arr, sum));
	}

	public static boolean isPresent(int arr[],int sum) {
		int n = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < n - 3; i++) {
			for(int j=i+1;j<n-2;j++){
				int high = n-1;
				int low = j+1;
				while(low<high){
					if((arr[i] + arr[j] + arr[high] + arr[low]) == sum){
						System.out.println(arr[i] + " " + arr[j] + " " + arr[high] + " " + arr[low]);
						return true;
					}
						
					else if((arr[i] + arr[j] + arr[high] + arr[low]) < sum)
						low++;
					else
						high--;
				}
			}
		}
		return false;
	}

}
