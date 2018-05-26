package com.geeksforgeeks.dp;

/*
 * WAP to print max. sum with no adjacent elements
 * Similar to https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
 */

public class SumWithNo2Adjacent {

	public static void main(String[] args) {
		//int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		//int a[] = {6, 7, 1, 3, 8, 2, 4};
		int a[] = {5, 3, 4, 11, 2};
		findLargestSum(a);
	}

	private static void findLargestSum(int[] a) {
		int M[] = new int[a.length];
		M[0] = a[0];
		M[1] = a[0] > a[1] ? a[0] : a[1];
		for(int i=2;i<a.length;i++){
			M[i] = Math.max(M[i-2] + a[i],M[i-1]);
		}
		System.out.println("Max. sum with no adjacent value : " + M[a.length-1]);
	}
}
