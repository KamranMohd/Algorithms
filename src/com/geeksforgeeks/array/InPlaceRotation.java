package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */
public class InPlaceRotation {

	public static void main(String[] args) {
		int mat[][] =
	        {
	            {1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {9, 10, 11, 12},
	            {13, 14, 15, 16}
	        };
		System.out.println("Matrix before rotation");
		printMatrix(mat, mat.length);
		System.out.println("Matrix after rotation");
		doRotation(mat, mat.length);
	}
	
	public static void doRotation(int [][] mat, int n){
		//	For n rows square matrix, we will have to 
		//	do n/2 rounds
		for(int i=0;i<n/2;i++){
			//	For each round, we will rotate the 
			//	elements on the boundary in clockwise direction
			for(int j=i;j<n-i-1;i++){
				int temp = mat[i][j];
				mat[i][j] = mat[n-j-1][n-i-1];
				mat[n-j-1][n-i-1] = mat[n-i-1][n-j-1];
				mat[n-i-1][n-j-1] = temp;
			}
		}
		printMatrix(mat, n);
	}
	
	public static void printMatrix(int [][] mat, int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(mat[i][j] +  " ");
			System.out.println();
		}
	}

}
