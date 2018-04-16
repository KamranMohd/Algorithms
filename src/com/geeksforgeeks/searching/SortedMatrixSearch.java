package com.geeksforgeeks.searching;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
		int x = 38;
		findElementIndex(mat, x);
	}
	
	public static void findElementIndex(int [][] mat, int element){
		int row = mat.length, col = mat[0].length;
		int rowIndex = -1;
		for(int i=row-1;i>0;i--){
			if(mat[i][0] <= element){
				rowIndex = i;
				break;
			}
		}
		int elementIndex = binarySearch(mat[rowIndex], 0, col-1, element);
		if(elementIndex==-1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at row and col : " + rowIndex + "," + elementIndex);
	}

	private static int binarySearch(int[] is, int low, int high, int element) {
		if(low <= high){
			int mid = (high+low)/2;
			if(element == is[mid])
				return mid;
			else if(element < is[mid])
				return binarySearch(is, low, mid-1, element);
			else
				return binarySearch(is, mid+1, high, element);			
		}
		return -1;
	}
}