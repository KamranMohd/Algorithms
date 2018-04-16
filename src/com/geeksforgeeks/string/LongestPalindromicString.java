package com.geeksforgeeks.string;

public class LongestPalindromicString {

	public static void main(String[] args) {
		String str = "BBABCBCAB";
		//String str = "GEEKSFORGEEKS";
		System.out.println(lenLongestPalindrome(str,0,str.length()-1));
	}

	private static int lenLongestPalindrome(String str,int i, int j){
		if(i==j)
			return 1;
		else if(i+1==j && str.charAt(i)==str.charAt(j))
			return 2;
		else if(str.charAt(i)==str.charAt(j))
			return 2 + lenLongestPalindrome(str,i+1,j-1);
		else
			return Math.max(lenLongestPalindrome(str,i,j-1),lenLongestPalindrome(str,i+1,j));
	}
}
