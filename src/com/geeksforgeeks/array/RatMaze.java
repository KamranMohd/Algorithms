package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 * https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
 * https://www.geeksforgeeks.org/?p=12916
 */
public class RatMaze {
	static int pathCount = 0;

	public static void main(String[] args) {

		// int maze[][] = {{0, 0, 0, 0},
		// {0, -1, 0, 0},
		// {-1, 0, 0, 0},
		// {0, 0, 0, 0}};
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		getPathCount(maze, 0, 0, maze.length - 1, maze[0].length - 1);
		System.out.println("Total paths : " + pathCount);
		System.out.println("Total paths : " + getPathCount2(maze, 0, 0, maze.length - 1, maze[0].length - 1));
	}

	public static void getPathCount(int[][] maze, int i, int j, int m, int n) {
		if (i == m && j == n)
			pathCount++;
		if ((i > m || j > n))
			return;
		if ((maze[i][j] == -1))
			return;
		getPathCount(maze, i + 1, j, m, n);
		getPathCount(maze, i, j + 1, m, n);
	}

	public static int getPathCount2(int[][] maze, int i, int j, int m, int n) {
		if (i == m && j == n)
			return 1;
		if ((i > m || j > n))
			return 0;
		if ((maze[i][j] == -1))
			return 0;
		return getPathCount2(maze, i + 1, j, m, n) + getPathCount2(maze, i, j + 1, m, n);
	}

}
