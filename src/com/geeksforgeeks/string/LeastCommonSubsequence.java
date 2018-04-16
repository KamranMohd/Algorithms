package com.geeksforgeeks.string;

public class LeastCommonSubsequence {

	public static void main(String[] args) {
		//String str1 = "ABCDGH";
		//String str2 = "AEDFHR";
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		System.out.println(LCS(str1,str2));
	}
	
	private static int LCS(String str1,String str2){
		//System.out.println(str1 + " " + str2  +  " " + length);
		if(str1.length()==0 || str2.length()==0)
			return 0;
		if(str1.charAt(0)==str2.charAt(0)){
			return 1 + LCS(str1.substring(1), str2.substring(1));
		}
		else
			return Math.max(LCS(str1.substring(1), str2),LCS(str1, str2.substring(1)));
	}
}