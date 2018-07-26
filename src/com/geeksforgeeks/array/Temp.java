package com.geeksforgeeks.array;

import java.util.HashSet;
import java.util.Set;

public class Temp {

	public static void main(String[] args) {
		String str1 = "abcdefacbccbagfacbacer";
		String str2 = "abc";
		System.out.println(getMaxLength(str1, str2));
	}

	public static int getMaxLength(String str1, String str2) {
		Set<Character> set = new HashSet<>();

		// Store all the characters in string2 inside a hashset
		for (int i = 0; i < str2.length(); i++)
			set.add(str2.charAt(i));

		int maxLen = 0, len = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (set.contains(str1.charAt(i)))
				len++;
			else {
				maxLen = Math.max(maxLen, len);
				len = 0;
			}
		}
		//System.out.println(startIndex + "  " + endIndex);
		return maxLen;
	}
}
