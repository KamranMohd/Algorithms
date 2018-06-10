package com.geeksforgeeks.backtracking;

/*
 * https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
 */
public class RatInAMaze {

	public static void main(String[] args) {
		int maze[][] = { { 2, 1, 0, 0 }, { 3, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 } };
		int sol[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int m = maze.length-1;
		int n = maze[0].length-1;
		solveRatMaze(maze, 0, 0, m, n, sol);
		//	Print solution
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++)
				System.out.print(sol[i][j] +  " ");
			System.out.println();
		}
	}

	public static boolean solveRatMaze(int[][] maze, int x, int y, int m, int n, int[][] sol) {
		if (x == m && y == n) {
			sol[x][y] = 1;
			return true;
		}
		if ((x > m || y > n) || maze[x][y] == 0)
			return false;
		sol[x][y] = 1;
		for (int i = 1; i <= maze[x][y]; i++) {
			if (solveRatMaze(maze, x + i, y, m, n, sol) == true)
				return true;
			if (solveRatMaze(maze, x, y + i, m, n, sol) == true)
				return true;
		}
		sol[x][y] = 0;
		return false;
	}

}
