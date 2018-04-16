package com.geeksforgeeks.recursion;

/*
 * WAP to find the length of the longest common subsequence and print it
 * http://www.geeksforgeeks.org/longest-common-subsequence/
 */

public class LCS {
	public static void main(String[] args) {
		String l1 = "AGGTAB";
		String l2 = "GXTXAYB";
		System.out.println(lcs(l1,l2,l1.length(),l2.length()));
	}
	public static int lcs(String l1,String l2,int lengthL1, int lengthL2){
		if(lengthL1==0 || lengthL2==0)
			return 0;
		else if(l1.charAt(lengthL1-1)==l2.charAt(lengthL2-1))
			return 1+lcs(l1,l2,lengthL1-1,lengthL2-1);
		else
			return max(lcs(l1,l2,lengthL1-1,lengthL2),lcs(l1,l2,lengthL1,lengthL2-1));
	}
	private static int max(int lcs, int lcs2) {
		return lcs>lcs2?lcs:lcs2;
	}
}
