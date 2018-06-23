package com.geeksforgeeks.dp;
/*
 * https://www.geeksforgeeks.org/shortest-common-supersequence/
 * https://www.geeksforgeeks.org/shortest-possible-combination-two-strings/
 */
public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		String X = "AGGTAB";
	    String Y = "GXTXAYB";
	    System.out.println(getLengthRecur(X, Y, X.length(), Y.length()));
	    System.out.println(getLenDP(X, Y, X.length(), Y.length()));
	}
	
	public static int getLengthRecur(String str1, String str2,int m, int n){
		
		if(n==0)
			return m;
		if(m==0)
			return n;
		if(str1.charAt(m-1)==str2.charAt(n-1))
			return 1 + getLengthRecur(str1, str2, m-1, n-1);
		return 1 + Math.min(getLengthRecur(str1, str2, m-1, n), getLengthRecur(str1, str2, m, n-1));
	}
	
	public static int getLenDP(String str1, String str2, int m,int n){
		int dp[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0)
					dp[i][j] = j;
				else if(j==0)
					dp[i][j] = i;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else 
					dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}

}
