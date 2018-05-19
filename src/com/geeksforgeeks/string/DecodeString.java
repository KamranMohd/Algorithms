package com.geeksforgeeks.string;

/*
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/decode-1-6eab2976/
 */
public class DecodeString {

	public static void main(String[] args) {
		//String str = "wrien";
		String str = "reen";
		printDecodedString(str);
	}

	public static void printDecodedString(String str) {
		int len = str.length();
		int low = 0, high = len - 1;
		char[] dec = new char[len];
		for (int i = high; i >= 0; i--) {
			dec[high] = str.charAt(i);
			high--;
			i = i - 1;
			if (i >= 0) {
				dec[low] = str.charAt(i);
				low++;
			}
		}
		System.out.println(new String(dec));
	}
}
