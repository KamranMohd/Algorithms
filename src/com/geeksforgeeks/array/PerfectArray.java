package com.geeksforgeeks.array;

/*
 * There is an array contains some non-negative integers. Check whether the array is perfect or not. An array is called perfect 
 * if it is first strictly increasing, then constant and finally strictly decreasing. Any of the three parts can be empty.
 * https://practice.geeksforgeeks.org/problems/perfect-array/0
 */
import java.util.Scanner;

public class PerfectArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
			int arraySize = sc.nextInt();
			int [] nums = new int[arraySize];
			for(int j=0;j<arraySize;j++)
				nums[j] = sc.nextInt();
			System.out.println(isPerfect(nums));
		}
		sc.close();
	}
	
	public static String isPerfect(int [] arr){
		boolean isPerfect = true;
		int low=0,high=arr.length-1;
		while(low < high && arr[low] < arr[low+1])
			low++;
		while(high > 0 && arr[high] < arr[high-1])
			high--;
		for(int i=low;i<high;i++){
			if(arr[i]!=arr[i+1])
				isPerfect = false;
		}
		return isPerfect==true?"Yes":"No";
	}
}