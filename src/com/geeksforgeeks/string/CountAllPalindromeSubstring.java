package com.geeksforgeeks.string;

public class CountAllPalindromeSubstring {

	public static void main(String[] args) {
		//String str = "abaab";
		String str = "abbaeae";
		System.out.println(getPalinSubCount(str,0,str.length()-1));
	}
	
	public static int getPalinSubCount(String str,int low, int high){
		if(low>=high)
			return 0;
		if(high==low+1 && str.charAt(low)==str.charAt(high))
			return 1;
		else if(isPalindrome(str.substring(low,high+1)))
			return 1 + getPalinSubCount(str, low+1, high) + getPalinSubCount(str, low, high-1) - getPalinSubCount(str, low+1, high-1);
		else
			return getPalinSubCount(str, low+1, high) + getPalinSubCount(str, low, high-1) - getPalinSubCount(str, low+1, high-1);
	}

	private static boolean isPalindrome(String str) {
		int i=0,j=str.length()-1;
		while(i<=j){
			if(str.charAt(i)!=str.charAt(j))
				return false;
			i++;j--;
		}
		return true;
	}
}