package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
 * 
 */
public class SearchElementWithAdjDiffK {

	public static void main(String[] args) {
		//int arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3} ;
		//int x = 3;
		//int k = 1;
		//int arr[] =  {1, 2, 3, 4, 5, 4};
		//int x = 5;
		//int k = 1;
		//int arr[] = {2, 4, 5, 7, 7, 6};
	    //int x = 6;
	    //int k = 2;
		int arr[] = {20, 40, 50, 70, 70, 60};  
        int k = 20;
        int x = 60;
		System.out.println("Element found at index : " + getFirstOccurence(arr, 0, arr.length-1, x, k));
	}
	
	public static int getFirstOccurence(int [] arr, int low, int high, int x, int k){
		int index = 0;
		while(index<=high){
			if(arr[index]==x)
				return index;
			else
				index += Math.max(1, Math.abs(arr[index]-x)/k);
		}
		return -1;
	}
}