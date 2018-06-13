package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 */
public class LongestPathInMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		System.out.println("Length of the longest path is "
				+ getMaxPath(mat, mat.length, mat[0].length));
	}

	public static int getMaxPath(int[][] mat, int rows, int cols) {
		// Create a table dp[i][j], such that it holds the max path
		// length starting from the point (i,j)
		int dp[][] = new int[rows][cols];

		// this will hold the final result
		int result = 1;

		// Initialize all the values with -1
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				dp[i][j] = -1;
		}

		// Iterate through each cell and consider it
		// as the starting point
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// If this subproblems is not already solved
				if (dp[i][j] == -1)
					dp[i][j] = getMaxDistFromCell(mat, i, j, rows, cols, dp);
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}

	private static int getMaxDistFromCell(int[][] mat, int x, int y, int rows,
			int cols, int[][] dp) {
		// Base condition
		if ((x < 0 || x >= rows) || (y < 0 || y >= cols))
			return 0;

		// If the subproblem is already solved
		if (dp[x][y] != -1)
			return dp[x][y];

		// Else check for all directions
		// Move left
		if (y > 0 && (mat[x][y - 1] == (1 + mat[x][y])))
			return dp[x][y] = 1 + getMaxDistFromCell(mat, x, y - 1, rows, cols, dp);
		// Move right
		if (y + 1 < cols && (mat[x][y + 1] == (1 + mat[x][y])))
			return dp[x][y] = 1 + getMaxDistFromCell(mat, x, y + 1, rows, cols, dp);
		// Move downwards
		if (x + 1 < rows && (mat[x + 1][y] == (1 + mat[x][y])))
			return dp[x][y] = 1 + getMaxDistFromCell(mat, x + 1, y, rows, cols, dp);
		//	Move upwards
		if (x > 0 && (mat[x - 1][y] == (1 + mat[x][y])))
			return dp[x][y] = 1 + getMaxDistFromCell(mat, x - 1, y, rows, cols, dp);

		// If none of the case is valid
		return dp[x][y] = 1;
	}

}
