package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 */
public class EditDistance {

	public static void main(String[] args) {
		// String str1 = "sunday";
		// String str2 = "saturday";
		//String str1 = "lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq";
		//String str2 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcaceh";
		/*String str1 = "lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxs";
		String str2 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxix";*/
		String str1 = "lrbbmqbhc";
		String str2 = "hnwnkuewhs";
		System.out
				.println("Recursion: "
						+ getEditCostRecursion(str1, str2, str1.length(),
								str2.length()));
		System.out.println("DP : "
				+ getEditCostDP(str1, str2, str1.length(), str2.length()));
	}

	/*
	 * Method 1: Using recursion
	 */
	public static int getEditCostRecursion(String str1, String str2, int m,
			int n) {
		// Base conditions: If str1 is empty, then we have to insert
		// all characters of n in str1
		if (m == 0)
			return n;
		// If str2 is empty, the remove all the characters from
		// str1 to make it empty too
		if (n == 0)
			return m;
		// If both the characters are same, then leave both
		// the characters and recurse for the remaining string lengths
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return getEditCostRecursion(str1, str2, m - 1, n - 1);

		// Else, perform all the operations one by one and
		// find the minimum of all the 3 operations
		// insert, delete, replace in the order
		return 1 + Math.min(getEditCostRecursion(str1, str2, m, n - 1), Math
				.min(getEditCostRecursion(str1, str2, m - 1, n),
						getEditCostRecursion(str1, str2, m - 1, n - 1)));
	}

	/*
	 * Method 2: Using dynamic programming
	 */
	public static int getEditCostDP(String str1, String str2, int m, int n) {
		// Create a table[i][j] such that it contains
		// the minimum cost to convert str1[0..i-1] to str2[0...j-1]
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If str1 is blank, then insert the length of j
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i][j - 1],
							Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
			}
		}
		return dp[m][n];
	}
}
