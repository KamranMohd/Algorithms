package com.geeksforgeeks.array;

public class MaximumDifference {

	public static void main(String[] args) {
		//int arr[] = {1, 2, 90, 10, 110};
		int arr[] = {1, 2, 6, 80, 100};
		System.out.println(getMaxDiff(arr));
	}
	
	public static int getMaxDiff(int arr[]){
		int maxDiff = 0, minEle = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i] - minEle > maxDiff)
				maxDiff = arr[i] - minEle;
			if(arr[i] < minEle)
				minEle = arr[i];
		}
		return maxDiff;
	}
}