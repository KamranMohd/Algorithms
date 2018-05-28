package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/leaders-in-an-array/
 */

import java.util.Stack;

public class LeadersInArray {

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		printLeaders(arr, arr.length);
		System.out.println();
		printLeadersOpt(arr, arr.length);
	}

	/*
	 * Method 1: Using stacks Time complexity : O(n) Space complextiy : O(n)
	 */
	public static void printLeaders(int[] arr, int n) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() < arr[i]) {
				s.pop();
			}
			if (s.isEmpty() == true) {
				System.out.print(arr[i] + " ");
			}
			s.push(arr[i]);
		}
	}

	/*
	 * Method 2: Using stacks Time complexity : O(n) Space complextiy : O(1)
	 */
	public static void printLeadersOpt(int[] arr, int n) {
		int max = arr[n - 1];
		System.out.print(arr[n - 1] + " ");
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > max) {
				System.out.print(arr[i] + " ");
				max = arr[i];
			}

		}
	}
}
