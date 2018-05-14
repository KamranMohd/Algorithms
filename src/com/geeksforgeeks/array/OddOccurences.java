package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
 */

public class OddOccurences {

	public static void main(String[] args) {
		// int arr[] = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
		// int [] arr = {12, 23, 34, 12, 12, 23, 12, 45};
		// int [] arr = {10,20};
		int[] arr = { 10, 10, 20, 20 };
		printOddTimesNum(arr);
	}

	public static void printOddTimesNum(int arr[]) {
		int xor = arr[0], n = arr.length, x = 0, y = 0;

		// XOR all the elements of the array. This will give XOR of 2 nums
		// appearing odd number of times
		for (int i = 1; i < n; i++)
			xor ^= arr[i];

		// Get the rightmost set bit of xor2
		int rightmostBit = xor & ~(xor - 1);

		// One of the 2 odd nums will have this bit set and other will not have
		// it set.
		// If we xor all the elements (some even times num + 1 odd occurence
		// num) with this bit set, the even occurence num will return 0 and the odd
		// occurence number will be returned.
		for (int i = 0; i < n; i++) {
			if ((rightmostBit & arr[i]) > 0)
				x = x ^ arr[i];
			else
				y = y ^ arr[i];
		}
		System.out
				.println("Number with odd occurences : (" + x + "," + y + ")");
	}
}
