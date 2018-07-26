package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaximumSizeSquareMatWith1s {

	public static void main(String[] args) {
		int mat[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		printMatrix(mat, mat.length, mat[0].length);

	}

	public static void printMatrix(int[][] mat, int rows, int cols) {
		// Create an auxiliary sum matrix[][]
		int sum[][] = new int[rows][cols];

		// Initialize first row and col with first row
		// and col of mat[][]

		for (int i = 0; i < cols; i++)
			sum[0][i] = mat[0][i];

		for (int i = 0; i < rows; i++)
			sum[i][0] = mat[i][0];

		// For other entries follow the below procedure
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (mat[i][j] == 1) {
					sum[i][j] = Math.min(sum[i - 1][j - 1],
							Math.min(sum[i - 1][j], sum[i][j - 1])) + 1;
				} else
					sum[i][j] = 0;
			}
		}
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++)
				System.out.print(sum[i][j] + " ");
			System.out.println();
		}
		

		// Find the max value in the sum[][] matrix
		// along with the index of of rows and cols
		int max = Integer.MIN_VALUE, max_i = -1, max_j = -1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (max < sum[i][j]) {
					max = sum[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}

		// Now print the matrix from bottom up

		for (int i = max_i; i > (max_i - max); i--) {
			for (int j = max_j; j > (max_j - max); j--) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
