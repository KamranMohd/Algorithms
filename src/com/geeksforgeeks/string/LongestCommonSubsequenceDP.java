package com.geeksforgeeks.string;

public class LongestCommonSubsequenceDP {

	public static void main(String[] args) {
		//String str1 = "ABCDGH";
		//String str2 = "AEDFHR";
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		int LCS[][] = LCS(str1,str2);
		//System.out.println(LCS[str1.length()][str2.length()]);
		printLCS(str1, str2, LCS);
	}
	
	private static int[][] LCS(String str1,String str2){
		int m = str1.length();
		int n = str2.length();
		int LCS[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					LCS[i][j] = 0;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					LCS[i][j] = LCS[i-1][j-1] + 1;
				else 
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		return LCS;
	}
	
	private static void printLCS(String str1,String str2, int [][] LCS){
		System.out.println(str1+  " " + str2);
		StringBuffer str = new StringBuffer("");
		int i = str1.length(),j = str2.length();
		while(i>0 && j>0){
			if(LCS[i][j]==LCS[i-1][j-1]+1){
				str.append(str1.charAt(i-1));
				i--;j--;
			}
			else if(LCS[i-1][j] > LCS[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println(str);
	}
}