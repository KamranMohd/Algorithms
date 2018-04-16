package com.geeksforgeeks.searching;

public class FloorAndCeil2 {

	public static void main(String[] args) {
		int arr [] = {1, 2, 8, 8,10, 10, 10,10,12, 19};
		int x = 10;
		System.out.println(findCeil(arr,0,arr.length-1,x));
	}

	public static int findCeil(int [] arr, int low, int high, int x){
		if(high<low)
			return -1;
		int mid = (low+high)/2;
		if(mid > low && arr[mid] > x && arr[mid-1] <= x)
			return arr[mid];
		if(mid < high && arr[mid] <= x && arr[mid+1] > x)
			return arr[mid+1];
		if(arr[mid] > x)
			return findCeil(arr,low,mid-1,x);
		else
			return findCeil(arr,mid+1,high,x);
	}
}
