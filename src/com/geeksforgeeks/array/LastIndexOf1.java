package com.geeksforgeeks.array;

/*
 * https://practice.geeksforgeeks.org/problems/last-index-of-1/0
 */
public class LastIndexOf1 {

	public static void main(String[] args) {
		// String str =
		// "11111111111111111111111111111111100000000000000000000000000";
		String str = "0011111";
		System.out.println(lastIndex(str.toCharArray(), 0, str.length() - 1));

	}

	public static int lastIndex(char[] ch, int l, int r) {
		if (l > r)
			return -1;
		if (ch[r] > ch[l])
			return r;
		if (ch[l] == ch[r] && ch[l] == '0')
			return -1;
		if (ch[l] == ch[r] && ch[r] == '1')
			return r;
		int mid = l + (r - l) / 2;
		if (ch[mid] == '0')
			return lastIndex(ch, l, mid - 1);
		if (ch[mid] == ch[mid + 1])
			return lastIndex(ch, mid + 1, r);
		return mid;
	}

}
