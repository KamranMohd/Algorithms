package com.geeksforgeeks.searching;

public class AdjacentDiffOne {

	public static void main(String[] args) {
		//int arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3};
		//int x = 3;
		int arr[] =  {1, 2, 3, 4, 5, 4};
	    int x = 5;
		System.out.println(getFirstIndex(arr, x));
	}

	public static int getFirstIndex(int[] arr, int x) {
		for (int i = 0; i < arr.length;) {
			if(arr[i]==x)
				return i;
			int diff = Math.abs(arr[i] - x);
			i = i + diff;
		}
		return -1;
	}
}
