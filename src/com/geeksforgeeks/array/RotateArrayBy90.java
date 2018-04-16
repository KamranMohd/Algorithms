package com.geeksforgeeks.array;

public class RotateArrayBy90 {

	public static void main(String[] args) {
		int mat[][] =
		    {
		        {1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16}
		    };
		int rows = mat.length;
		System.out.println("Matrix before rotation");
		for(int i=0;i<rows;i++){
			for(int j=0;j<rows;j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		rotateMatrix(mat, rows);
		
	}
	
	public static void rotateMatrix(int [][] mat, int rows){
		int outerLoop = rows/2, lastIndex = rows-1;
		for(int i=0;i<outerLoop;i++){
			for(int j=i;j<lastIndex-i;j++){
				int temp = mat[i][j];
				mat[i][j] = mat[j][lastIndex-i];
				mat[j][lastIndex-i] = mat[lastIndex-i][lastIndex-j];
				mat[lastIndex-i][lastIndex-j] = mat[lastIndex-j][i];
				mat[lastIndex-j][i] = temp;
			}
		}
		System.out.println("Matrix after rotation");
		for(int i=0;i<rows;i++){
			for(int j=0;j<rows;j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
}