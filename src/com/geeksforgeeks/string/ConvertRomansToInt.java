package com.geeksforgeeks.string;

public class ConvertRomansToInt {

	public static void main(String[] args) {
		String str = "MCMIV";
		System.out.println(getIntegerValue(str));
	}

	public static int getIntegerValue(String roman) {
		int res = 0;
		for (int i = 0; i < roman.length(); i++) {
			int val1 = value(roman.charAt(i));
			if (i + 1 < roman.length()) {
				int val2 = value(roman.charAt(i + 1));
				if (val1 >= val2) {
					res = res + val1;
				} else {
					res = res + val2 - val1;
					i++;
				}
			} else {
				res = res + val1;
				i++;
			}
		}
		return res;
	}

	// This function returns value of a Roman symbol
	static int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;

		return -1;
	}

}
