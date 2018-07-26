package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/amazon-interview-experience-set-130-sdet-1/
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 */

public class NearestPerfectSquare {

	public static void main(String[] args) {
		int n = 66;
		System.out.println("Nearest square to the number " + n + " : "
				+ getNearestSquare(n));

	}

	public static int getNearestSquare(int n) {
		int squareRoot = getSquareRoot(n);
		if ((n - (squareRoot * squareRoot)) < ((squareRoot + 1)
				* (squareRoot + 1) - n))
			return squareRoot * squareRoot;
		else
			return (squareRoot + 1) * (squareRoot + 1);
	}

	public static int getSquareRoot(int n) {
		if (n == 0 || n == 1)
			return n;
		int start = 1, end = n / 2, ans = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int sq = mid * mid;
			if (sq == n)
				return mid;
			else if (sq < n) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
		}
		return ans;
	}
}
