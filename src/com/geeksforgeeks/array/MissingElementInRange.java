package com.geeksforgeeks.array;

public class MissingElementInRange {

	public static void main(String[] args) {
		//int arr[] = {10, 12, 11, 15}, low = 10, high = 15;
		int arr[] = {1, 14, 11, 51, 15},low = 50, high = 55;
		printMissingElement(arr, low, high);
	}
	
	private static void printMissingElement(int [] arr, int low, int high){
		int range = high-low+1;
		int j=low;
		int r_arr[] = new int[range];
		for(int i=0;i<range;i++)
			r_arr[i] = j++;
		for(int i=0;i<arr.length;i++){
			if((arr[i]-low) >= 0 && (arr[i]-low) < range){
				r_arr[arr[i]-low] = -r_arr[arr[i]-low];
			}
				
		}
		for(int i=0;i<range;i++)
			if(r_arr[i]>0)
				System.out.print(r_arr[i] + " ");
	}
}