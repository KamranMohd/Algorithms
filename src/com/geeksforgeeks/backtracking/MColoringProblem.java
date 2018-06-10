package com.geeksforgeeks.backtracking;

/*
 * https://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
 */
public class MColoringProblem {
	static int N = 4;

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3; // Number of colors
		int cols[] = new int[N];
		mColorPossible(graph, cols, 0, m);
		//	Print colors array
		for(int i : cols)
			System.out.print(i + " ");
	}

	public static boolean mColorPossible(int[][] graph, int[] cols, int v, int m) {
		// Base condition
		if (v == N)
			return true;
		// Try each color on the current node
		for (int i = 1; i <= m; i++) {
			if (isSafe(graph, i, cols, v) == true) {
				cols[v] = i;
				if (mColorPossible(graph, cols, v + 1, m) == true)
					return true;
				cols[v] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] graph, int c, int[] cols, int v) {
		for (int i = 0; i < N; i++) {
			if (graph[v][i] == 1 && c == cols[i])
				return false;
		}
		return true;
	}

}
