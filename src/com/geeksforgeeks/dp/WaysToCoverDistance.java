package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class WaysToCoverDistance {

	public static void main(String[] args) {
		int dist = 3;
		System.out.println("Number of ways to reach the top using recursion : " + getNumberofWays(dist));
		System.out.println("Number of ways to reach the top using DP : " + getNumberOfWaysDP(dist));
	}

	public static int getNumberofWays(int dist) {
		if (dist < 0)
			return 0;
		if (dist == 0)
			return 1;
		return getNumberofWays(dist - 1) + getNumberofWays(dist - 2)
				+ getNumberofWays(dist - 3);
	}

	public static int getNumberOfWaysDP(int dist) {
		int dp[] = new int[dist + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= dist; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[dist];
	}

}
