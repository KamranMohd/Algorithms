package com.geeksforgeeks.string;

/*
 * https://www.geeksforgeeks.org/minimum-number-appends-needed-make-string-palindrome/
 */
public class AppendToPal {

	public static void main(String[] args) {
		//String str = "abede";
		//String str = "aabb";
		String str = "gesks";
		System.out.println("Min appends : " + minAppends(str));
	}

	public static int minAppends(String str) {
		int n = str.length(), appends = 0;
		if (n == 0)
			return 0;
		while (str.length() > 1) {
			if (isPalindrome(str))
				return appends;
			else {
				appends++;
			}
			str = str.substring(1);
		}
		return appends;
	}

	public static boolean isPalindrome(String str) {
		int low = 0, high = str.length() - 1;
		while (low < high) {
			if (str.charAt(low) == str.charAt(high)) {
				low++;
				high--;
			} else
				return false;
		}
		return true;
	}
}
