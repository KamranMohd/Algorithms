package com.geeksforgeeks.greedy;

/*
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
 */
public class MinOperations {

	public static void main(String[] args) {
		int N = 8;
		System.out.println(getMinOperations(N));
	}

	public static int getMinOperations(int n) {
		if (n == 0)
			return 0;
		int operations = 0;
		while (n > 0) {
			if (n % 2 == 0) {
				n = n / 2;
				operations++;
			} else {
				n = n - 1;
				operations++;
			}
		}
		return operations;
	}
}