package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
 */
public class MinInsertPalin {

	public static void main(String[] args) {
		String str = "geeks";
		System.out.println("Min insertion using recursion : "
				+ minInsertRec(str, 0, str.length() - 1));
		System.out.println("Min insertion using DP : "
				+ minInsertDp(str));
	}

	public static int minInsertRec(String str, int low, int high) {
		if (low > high)
			return Integer.MAX_VALUE;
		if (low == high)
			return 0;
		if (low == high - 1)
			return (str.charAt(low) == str.charAt(high)) ? 0 : 1;
		return (str.charAt(low) == str.charAt(high)) ? minInsertRec(str,
				low + 1, high - 1) : Math.min(minInsertRec(str, low + 1, high),
				minInsertRec(str, low, high - 1)) + 1;
	}

	public static int minInsertDp(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];
		int l, h, gap;
		for (gap = 1; gap < n; gap++) {
			for (l = 0, h = gap; h < n; l++, h++) {
				dp[l][h] = str.charAt(l) == str.charAt(h) ? dp[l + 1][h - 1]
						: (Math.min(dp[l + 1][h], dp[l][h - 1]) + 1);
			}
		}
		return dp[0][n-1];
	}
}
