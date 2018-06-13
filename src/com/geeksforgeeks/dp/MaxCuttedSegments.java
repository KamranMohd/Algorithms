package com.geeksforgeeks.dp;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/cutted-segments/0
 * https://hackerranksolutionc.blogspot.com/2017/10/cutted-segments.html
 */
public class MaxCuttedSegments {

	public static void main(String[] args) {
		// int len = 4;
		// int x = 2, y = 1, z = 1;
		int len = 7;
		int x = 5, y = 5, z = 2;
		System.out.println(getMaxSegments(len, x, y, z));
	}

	public static int getMaxSegments(int len, int x, int y, int z) {
		// Base condition: If len<=0, the we can't cut it into segments
		if (len <= 0)
			return 0;
		// Create a table dp[], such that dp[i] stores maximum segments
		// that can be done for len i
		int dp[] = new int[len + 1];

		// Initialize all the elements as -1 or Integer.MAX_INT
		// except the first element
		Arrays.fill(dp, 1, len + 1, -1);

		// Find the min value from the options
		int min = Math.min(x, Math.min(y, z));

		// Iterate through all possible length segments starting with the min
		// value
		for (int i = min; i <= len; i++) {
			// dp[i-x] == -1, then means the len i-x can't be achieved
			// as of now
			if (i >= x && dp[i - x] != -1)
				dp[i] = Math.max(dp[i], dp[i - x] + 1);
			if (i >= y && dp[i - y] != -1)
				dp[i] = Math.max(dp[i], dp[i - y] + 1);
			if (i >= z && dp[i - z] != -1)
				dp[i] = Math.max(dp[i], dp[i - z] + 1);
		}
		for (int i : dp)
			System.out.print(i + " ");
		System.out.println();
		return dp[len];
	}

}
