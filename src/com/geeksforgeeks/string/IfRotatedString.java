package com.geeksforgeeks.string;

/*
 * https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
 */
public class IfRotatedString {

	public static void main(String[] args) {
		String str1 = "fsbcnuvqhffbsaqxwp";
		String str2 = "wpfsbcnuvqhffbsaqx";
		System.out.println(ifRotatedString(str1, str2));
	}

	public static int ifRotatedString(String str1, String str2) {
		String newStr = str1 + str1;
		//System.out.println(newStr.substring(2, 2 + str1.length()));
		//System.out.println(newStr.substring(str1.length() - 2, str1.length() - 2 + str1.length()));
		//System.out.println(str2);
		if (str2.equals(newStr.substring(2, 2 + str1.length())))
			return 1;
		if (str2.equals(newStr.substring(str1.length() - 2, str1.length() - 2 + str1.length())))
			return 1;
		return 0;
	}

}
