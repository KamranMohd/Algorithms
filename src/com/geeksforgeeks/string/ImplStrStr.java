package com.geeksforgeeks.string;
/*
 * https://practice.geeksforgeeks.org/problems/implement-strstr/1
 */
public class ImplStrStr {

	public static void main(String[] args) {
		String str1 = "GeeksForGeeks";
		String str2 = "Fr";
		//String str2 = "For";
		System.out.println(returnStrStr(str1, str2));
	}

	public static int returnStrStr(String str1, String str2) {
		if (str2.length() > str1.length())
			return -1;
		int startIndex = -1, j = 0;
		for (int i = 0; i < str1.length() && j < str2.length(); i++) {
			if (str1.charAt(i) == str2.charAt(j)){
				if(j==0)
					startIndex = i;
				j++;
			}
			else
				j=0;
		}
		return (j==str2.length())?startIndex:-1;
	}
}
