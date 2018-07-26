package com.geeksforgeeks.greedy;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Pair implements Comparable<Pair> {
	int a, b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Pair o) {
		return this.b - o.b;
	}
}

public class MaxLengthChain {

	public static void main(String[] args) {
		int arr[] = { 5, 24, 39, 60, 15, 28, 27, 40, 50, 90 };
		// int arr[] = {5, 10, 1, 11};
		// int[] arr = { 3, 4, 2, 3, 1, 2 };
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i = i + 2) {
			list.add(new Pair(arr[i], arr[i + 1]));
		}
		Collections.sort(list);
		findMaxChainLength(list, arr.length / 2);
		findMaxChainLengthGreedy(list, arr.length / 2);
	}

	/*
	 * Method 1: Done using DP as a variation of longest increasng subsequence
	 */
	private static void findMaxChainLength(List<Pair> list, int n) {
		// Create a dp[] such that dp[i] holds the maximum
		// chain length upto index i

		// Initialize the values with 1
		int dp[] = new int[n];
		Arrays.fill(dp, 1);

		printList(list);
		// Iterate through each pair
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(i).a > list.get(j).b)
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		// Return the maximum value as the answer
		int max = dp[0];
		for (int i = 1; i < n; i++)
			max = Math.max(dp[i], max);
		for (int i : dp)
			System.out.println(i);
		System.out.println("Maximum chain length : " + max);
	}

	/*
	 * Method 2: Using greedy approach as variation of Activity selection
	 */
	private static void findMaxChainLengthGreedy(List<Pair> list, int n) {
		// Consider first value as the starting time
		// and second value as the ending time
		int current_end_time = list.get(0).b;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (list.get(i).a > current_end_time) {
				count++;
				current_end_time = list.get(i).b;
			}
		}
		System.out.println("Maximum chain length : " + count);
	}

	public static void printList(List<Pair> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).a + " " + list.get(i).b);
	}
}
