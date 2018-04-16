package com.geeksforgeeks.string;

public class CountAllPalindromeSubstringDP {

	public static void main(String[] args) {
		//String str = "abaab";
		String str = "abbaeae";
		System.out.println(getPalinSubCount(str,0,str.length()-1));
	}
	
	public static int getPalinSubCount(String str,int low, int high){
		int size = str.length();
		boolean pal[][] = new boolean[size][size];
		int count[][] = new int[size][size];
		//	Palindromic string of size 1
		for(int i=0;i<size;i++){
			pal[i][i] = true;
		}
		//	Palindromic string of size 2
		for(int i=0;i<size-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				pal[i][i+1] = true;
				count[i][i+1] = 1;
			}
		}
		//	Palindromic string of size gt 2
		for(int gap=2;gap<size;gap++){
			for(int i=0;i<size-gap;i++){
				int j = gap + i;
				if(str.charAt(i)==str.charAt(j) && pal[i+1][j-1]==true)
					pal[i][j] = true;
				if(pal[i][j]==true)
					count[i][j] = 1 + count[i+1][j] + count[i][j-1] - count[i+1][j-1];
				else
					count[i][j] = count[i+1][j] + count[i][j-1] - count[i+1][j-1];	
			}
		}
		return count[0][size-1];
	}
}