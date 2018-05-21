package com.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
 */

public class BracketBalancing {

	public static void main(String[] args) {
		//String str = "[]][][";
		String str = "[[][]]";
		System.out.println(getMinSwaps(str));
	}

	public static int getMinSwaps(String str) {
		int count = 0, result = 0;
		List<Integer> open = new ArrayList<>();

		// Store the indexes of all opening brackets in the list
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '[')
				open.add(i);
		}
		if (open.size() != str.length() / 2)
			return -1;

		char strArr[] = str.toCharArray();
		int listIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			if (strArr[i] == '[') {
				count++;
				listIndex++;
			} else
				count--;
			if (count < 0) {
				result += open.get(listIndex) - i;
				System.out
						.println("Swapping index at : " + i + "," + open.get(listIndex));
				swap(strArr, i, open.get(listIndex));
				System.out.println(strArr);
				listIndex++;
				count = 1;
			}
		}
		return result;
	}

	private static void swap(char[] str, int i, int listIndex) {
		char temp = str[i];
		str[i] = str[listIndex];
		str[listIndex] = temp;
	}
}
