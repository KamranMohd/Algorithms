package com.geeksforgeeks.backtracking;

/*
 * https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 */
public class NQueenProblem {

	public static void main(String[] args) {
		int N = 4;
		int mat[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		isQueenPlacable(mat, 0, N);
		// Print the position of the queens
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static boolean isQueenPlacable(int[][] mat, int col, int N) {
		if (col >= N)
			return true;
		// Check for each row in the column col
		for (int i = 0; i < N; i++) {
			if (isSafe(mat, i, col, N) == true) {
				mat[i][col] = 1;
				if (isQueenPlacable(mat, col + 1, N) == true)
					return true;
				mat[i][col] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] mat, int row, int col, int n) {
		// check for same row
		for (int i = 0; i < col; i++) {
			if (mat[row][i] == 1)
				return false;
		}
		// Check for left upper diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (mat[i][j] == 1)
				return false;
		}

		// Check for left lower diagonal
		for (int i = row, j = col; i < n && j >= 0; i++, j--) {
			if (mat[i][j] == 1)
				return false;
		}
		return true;
	}

}
