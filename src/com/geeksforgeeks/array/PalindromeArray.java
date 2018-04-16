package com.geeksforgeeks.array;

import java.util.Scanner;

public class PalindromeArray {

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
		int low=0,high=arr.length-1;
		boolean isPerfect=true;
		while(low<=high){
			if(arr[low]!=arr[high]){
				isPerfect = false;
				break;
			}
			low++;high--;
		}
		return isPerfect==false?"NOT PERFECT":"PERFECT";
	}
}