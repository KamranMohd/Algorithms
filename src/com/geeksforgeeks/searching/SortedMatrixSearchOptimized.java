package com.geeksforgeeks.searching;

public class SortedMatrixSearchOptimized {

	public static void main(String[] args) {
		int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
		int x = 29;
		findElementIndex(mat, x);
	}
	
	public static void findElementIndex(int [][] mat, int element){
		int row = mat.length, col = mat[0].length;
		int i=0,j=col-1;
		while(i<row && j>=0){
			if(mat[i][j]==element){
				System.out.println("Element found at : " + i + "," + j);
				break;
			}
			else if(mat[i][j] > element)
				j--;
			else
				i++;
		}
	}
}