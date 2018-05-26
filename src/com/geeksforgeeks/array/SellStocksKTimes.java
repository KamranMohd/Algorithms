package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 */
public class SellStocksKTimes {

	public static void main(String[] args) {
		int k = 2;
		int[] price = { 10, 22, 5, 75, 65, 80 };
		System.out.println("Maximum profit : "
				+ getMaxProfit(price, price.length, k));
	}

	public static int getMaxProfit(int[] price, int n, int k) {
		int profit[][] = new int[k + 1][n + 1];
		for (int i = 0; i <= n; i++)
			profit[0][i] = 0;
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// Fill in the matrix in bottom up manner
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int max = Integer.MIN_VALUE;
				for (int m = 0; m < j; m++)
					max = Math.max(max, price[j] - price[m] + profit[i - 1][m]);
				profit[i][j] = Math.max(profit[i][j - 1], max);
			}
		}
		return profit[k][n - 1];
	}

}
