package com.geeksforgeeks.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblemDP {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("i");dict.add("like");dict.add("sam");dict.add("sung");dict.add("samsung");
		dict.add("mobile");dict.add("cream");dict.add("ice");dict.add("icecream");dict.add("man");
		dict.add("go");dict.add("mango");
		String str = "likeulike";
		System.out.println(getWordBreak(str, dict, 0));
	}
	
	public static boolean getWordBreak(String str, Set<String> dict, int lowIndex){
		boolean wb[] = new boolean[str.length()+1];
		Arrays.fill(wb, false);
		for(int i=1;i<=str.length();i++){
			if(wb[i]==false && dict.contains(str.substring(0, i)))
				wb[i] = true;
			if(wb[i]==true){
				if(i==str.length())
					return true;
				for(int j=i+1;j<=str.length();j++){
					System.out.println("i : " + i + " j : " + j);
					if(wb[j]==false && dict.contains(str.substring(i,j)))
						wb[j] = true;
					if(j==str.length() && wb[j]==true)
						return true;
				}
			}	
		}
		return false;
	}
}