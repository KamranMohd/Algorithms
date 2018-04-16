package com.geeksforgeeks.string;

public class LongestPalindromicStringDP {

	public static void main(String[] args) {
		String str = "BBABCBCAB";
		//String str = "GEEKSFORGEEKS";
		System.out.println(lenLongestPalindrome(str));
	}

	private static int lenLongestPalindrome(String str){
		String str2 = new StringBuffer(str).reverse().toString();
		int len = str.length()+1;
		int pal[][] = new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(i==0 || j==0)
					pal[i][j] = 0;
				else if(str.charAt(i-1)==str2.charAt(j-1))
					pal[i][j] = pal[i-1][j-1] + 1;
				else
					pal[i][j] = Math.max(pal[i-1][j], pal[i][j-1]);
			}
		}
		return pal[len-1][len-1];
	}
}