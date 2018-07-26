package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/pascal-triangle/
 */
public class BinomialCoefficient {

	public static void main(String[] args) {
		int n = 10;
		printPascalTriangle(n);
		System.out.println("=======================================================");
		printPascalTriangleExtraSpace(n);
	}

	/*
	 * Method 1: Without using extra space
	 */
	public static void printPascalTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			int binCoe = 1;
			for (int j = 1; j <= i; j++) {
				System.out.print(binCoe + " ");
				binCoe = (binCoe * (i - j)) / j;
			}
			System.out.println();
		}
	}

	/*
	 * Method 2: Using extra space
	 */
	public static void printPascalTriangleExtraSpace(int n) {
		// Create an array with extra space
		int pascal[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				// The last and the last column prints 1
				if (j == 0 || j == i) {
					System.out.print("1" + " ");
					pascal[i][j] = 1;
				} else {
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
					System.out.print(pascal[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
