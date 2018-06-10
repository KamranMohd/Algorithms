package com.geeksforgeeks.string;

/*
 * https://www.geeksforgeeks.org/?p=19155
 */
public class LongestPalindSubsequence {

	public static void main(String[] args) {
		// String str = "GEEKSFORGEEKS";
		String str = "GEEKS FOR GEEKS";
		System.out.println("Length of LPS using recursion : " + longestPalSubsequenceRec(str, 0, str.length() - 1));
		System.out.println("Length of LPS using DP : " + longestPalSubsequenceDP(str));
	}

	public static int longestPalSubsequenceRec(String str, int i, int j) {
		// If only 1 character
		if (i == j)
			return 1;

		// If 2 characters and both are same
		if (j == i + 1 && str.charAt(i) == str.charAt(j))
			return 2;

		// If both the characters are same and length greater than 2
		if (str.charAt(i) == str.charAt(j))
			return longestPalSubsequenceRec(str, i + 1, j - 1) + 2;
		return Math.max(longestPalSubsequenceRec(str, i + 1, j), longestPalSubsequenceRec(str, i, j - 1));
	}

	public static int longestPalSubsequenceDP(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];

		// All characters are palindromic subsequence of length 1
		for (int i = 0; i < n; i++)
			dp[i][i] = 1;

		// For subsequence of length >= 2
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (str.charAt(i) == str.charAt(j) && len == 2)
					dp[i][j] = 2;
				else if (str.charAt(i) == str.charAt(j))
					dp[i][j] = dp[i + 1][j - 1] + 2;
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
			}
		}
		return dp[0][n - 1];
	}
}
