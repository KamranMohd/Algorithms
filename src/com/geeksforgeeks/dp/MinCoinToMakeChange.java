package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class MinCoinToMakeChange {

	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
		int value = 11;
		System.out.println(getMinCoinRecur(value, coins));
		System.out.println(getMinCoinDP(value, coins));
	}

	/*
	 * Method 1: Using recursion
	 */
	public static int getMinCoinRecur(int value, int coins[]) {
		if (value == 0)
			return 0;
		// Loop for each coin and check its value
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			// we will consider the coin only if its value is greater than the
			// value
			if (coins[i] <= value) {
				int temp = getMinCoinRecur(value - coins[i], coins);
				if(temp!=Integer.MAX_VALUE)
					result = Math.min(result, getMinCoinRecur(value - coins[i], coins) + 1);
			}
		}
		return result;
	}

	/*
	 * Method 2: Using DP
	 */
	public static int getMinCoinDP(int value, int coins[]) {
		int n = coins.length;
		// Create a table dp[] such that dp[i] holds the
		// minimum no of coins to make the value i
		int dp[] = new int[value + 1];
		// Initialize the array with maximum values
		for (int i = 0; i <= value; i++)
			dp[i] = Integer.MAX_VALUE;

		// If the value is 0
		dp[0] = 0;

		// Loop through each value and store the min coins in the
		// dp array
		for (int i = 1; i <= value; i++) {
			// For each value consider each the coins
			// that are smaller than the value.
			for (int j = 0; j < n; j++) {
				if (coins[j] <= i) {
					if(dp[i-coins[j]]!=Integer.MAX_VALUE)
					    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}
		return dp[value];
	}
}
