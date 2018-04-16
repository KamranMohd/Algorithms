package com.geeksforgeeks.dp;

/*
 * WAP to find the length of the longest common subsequence and print it
 * http://www.geeksforgeeks.org/longest-common-subsequence/
 */

public class LCS {

	public static void main(String[] args) {
		String l1 = "abcd1e2";//alsdfkjfjkdsal";//ABCDGH";//AGGTAB";
		String l2 = "bc12ea";//fdjskalajfkdsla";//"AEDFHR";//"GXTXAYB";
		int lCS[][] = lcs(l1,l2,l1.length(),l2.length());
		System.out.println(lCS[l1.length()][l2.length()]);
		printLCS(lCS, l1, l2);
	}
	
	public static int[][] lcs(String l1,String l2,int m,int n){
		int lcs[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					lcs[i][j] = 0;
				else if(l1.charAt(i-1) == l2.charAt(j-1))
					lcs[i][j] = 1 + lcs[i-1][j-1];
				else
					lcs[i][j] = max(lcs[i-1][j],lcs[i][j-1]);
			}
		}
		return lcs;
	}
	public static void printLCS(int [][] lcs,String l1,String l2){
		int m = l1.length(),n = l2.length();
		StringBuffer str = new StringBuffer("");
		while(m>0 && n>0){
			if(1+lcs[m-1][n-1]==lcs[m][n]){
				str.append(l1.charAt(m-1));
				m--;n--;
			}
			else if(lcs[m-1][n]==lcs[m][n])
				m--;
			else
				n--;
		}
		System.out.println(str.reverse());
	}

	private static int max(int i, int j) {
		return i>j?i:j;
	}
}