package com.geeksforgeeks.greedy;

/*
 * https://practice.geeksforgeeks.org/problems/coin-piles/0
 */
public class CoinPileProblem {

	public static void main(String[] args) {

		/*
		 * int coins[] = { 335, 501, 170, 725, 479, 359, 963, 465, 706, 146,
		 * 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383,
		 * 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895,
		 * 704, 812, 323, 334 }; int n = 42, k = 468;
		 */
		int coins[] = { 1, 2, 6, 10 }, n = 4, k = 3;
		System.out.println(removedCoins(coins, n, k));
	}

	public static int removedCoins(int[] coins, int n, int k) {
		if (n <= 1)
			return 0;
		int min_removal = Integer.MAX_VALUE;
		//	Consider all the pairs one by one
		for (int i = 0; i < n; i++) {
			int remove = 0;
			for (int j = 0; j < n; j++) {
				//	If the value of coin is less than the current value
				//	remove all the coins
				if (coins[j] < coins[i])
					remove += coins[j];
				//	Else, remove the difference minus k
				else if (coins[j] > coins[i] + k)
					remove += coins[j] - coins[i] - k;
			}
			//	Find the minimum after each iteration and min
			//	among all the iteration is the final answer
			min_removal = Math.min(min_removal, remove);
		}
		return min_removal;
	}
}
