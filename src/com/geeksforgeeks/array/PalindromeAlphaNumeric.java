package com.geeksforgeeks.array;

public class PalindromeAlphaNumeric {

	public static void main(String[] args) {
		//String str = "I am :IronnorI Ma, i";
		//String str = "Ab?sa/Ba";
		String str = "Ab?/#$%Ba";
		System.out.println("Is palindrome : " + isPalindrome(str.toLowerCase()));
	}

	public static boolean isPalindrome(String str) {
		int low = 0, high = str.length() - 1;
		while ((low < str.length()) && (high >= 0) && (low < high)) {
			while (low < str.length()
					&& (!Character.isDigit(str.charAt(low)) && !Character
							.isLetter(str.charAt(low))))
				low++;
			while (high >= 0
					&& (!Character.isDigit(str.charAt(high)) && !Character
							.isLetter(str.charAt(high))))
				high--;
			if (str.charAt(low) != str.charAt(high)) {
				return false;
			} else {
				low++;
				high--;
			}
		}
		return true;
	}
}