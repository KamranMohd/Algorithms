package com.geeksforgeeks.string;

/*
 * Given two strings X and Y consisting of only digits ‘0’ to ‘9’. Find minimum cost required to make the given two strings identical. 
 * Only operation allowed is to delete characters from any of the string. The cost of operation of deleting the digit ‘d’ is d units.
 * http://www.geeksforgeeks.org/minimum-cost-make-two-strings-identical-deleting-digits/
 * 
 */
public class CostOfIdenticalString {

	public static void main(String[] args) {
		String X = "3759", Y = "9350";
		System.out.println(getMinCost(X,Y));
	}
	
	private static int getMinCost(String str1,String str2){
		int costOfLCS = getCommonCost(str1, str2);
		int costX=0,costY=0;
		for(int i=0;i<str1.length();i++)
			costX += str1.charAt(i) - '0';
		for(int i=0;i<str2.length();i++)
			costY += str2.charAt(i) - '0';
		return costX + costY - costOfLCS;
	}
	private static int getCommonCost(String str1,String str2){
		int m = str1.length(),n = str2.length();
		int costOfLCS[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(j==0 || i==0)
					costOfLCS[i][j] = 0;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					costOfLCS[i][j] = costOfLCS[i-1][j-1] + (2*(str1.charAt(i-1)-'0'));
				else
					costOfLCS[i][j] = Math.max(costOfLCS[i-1][j], costOfLCS[i][j-1]);
			}
		}
		return costOfLCS[m][n];
	}
}