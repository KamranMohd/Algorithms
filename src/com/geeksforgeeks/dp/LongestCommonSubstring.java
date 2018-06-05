package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/print-longest-common-substring/
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		//String X = "GeeksforGeeks";
		//String Y = "GeeksQuiz";
		//String X = "zxabcdezy";
		//String Y = "yzabcdezx";
		String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
		int m = X.length();
		int n = Y.length();
		longestCommonSub(X, Y, m, n);
	}
	
	public static void longestCommonSub(String X, String Y, int m, int n){
		int res = 0, row=0, col = 0;
		int lcs[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					lcs[i][j] = 0;
				else if(X.charAt(i-1)==Y.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1] + 1;
					if(lcs[i][j] > res){
						res = lcs[i][j];
						row = i;
						col = j;
					}
				}
				else
					lcs[i][j] = 0;
			}
		}
		System.out.println("Length of longest common substring : " + res);
		
		//	Printing the longest common substring
		String substring = "";
		while(lcs[row][col]!=0){
			substring = X.charAt(row-1) + substring;
			row--;
			col--;
		}
		System.out.println("Longest common substring : " + substring);
	}

}
