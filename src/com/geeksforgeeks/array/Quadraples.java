package com.geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
 */

class PairSum {
	int first, second;

	public PairSum(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Quadraples {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int X = 91;
		printQuadraples(arr, X);
	}

	public static void printQuadraples(int[] arr, int X) {
		// Create pair wise sum array
		int n = arr.length;
		Map<Integer, PairSum> sum = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				sum.put(arr[i] + arr[j], new PairSum(i, j));
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				PairSum s = sum.get(X - (arr[i] + arr[j]));
				if (s != null && isCommon(s, i, j) == false) {
					System.out
							.println("Quadraples are (" + arr[s.first] + ","
									+ arr[s.second] + "," + arr[i] + ","
									+ arr[j] + ")");
					return;
				}
			}
		}
	}

	public static boolean isCommon(PairSum s, int i, int j) {
		if ((s.first != i && s.first != j) && (s.second != i && s.second != j))
			return false;
		return true;
	}
}
