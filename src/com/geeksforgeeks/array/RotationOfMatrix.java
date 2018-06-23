package com.geeksforgeeks.array;

public class RotationOfMatrix {

	public static void main(String[] args) {
		int mat[][] =
	        {
	            {1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {9, 10, 11, 12},
	            {13, 14, 15, 16}
	        };
		int n = mat.length;
		System.out.println("Matrix before rotation");
		printMatrix(mat, n);
		System.out.println("Matrix after rotation");
		rotateMatrix(mat, n);
		printMatrix(mat, n);

	}

	public static void rotateMatrix(int[][] mat, int n) {
		int cycles = n / 2, temp;
		for (int i = 0; i < cycles; i++) {
			for (int j = i; j < n - i - 1; j++) {
				temp = mat[i][j];
				mat[i][j] = mat[j][n - i - 1];
				mat[j][n - i - 1] = mat[n - i - 1][n - j - 1];
				mat[n - i - 1][n - j - 1] = mat[n - j - 1][i];
				mat[n - j - 1][i] = temp;
			}
		}
	}

	public static void printMatrix(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

}
