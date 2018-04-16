package com.geeksforgeeks.string;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("i");dict.add("like");dict.add("sam");dict.add("sung");dict.add("samsung");
		dict.add("mobile");dict.add("cream");dict.add("ice");dict.add("icecream");dict.add("man");
		dict.add("go");dict.add("mango");
		String str = "ilike";
		System.out.println(getWordBreak(str, dict, 0));
	}
	
	public static boolean getWordBreak(String str, Set<String> dict, int lowIndex){
		//	Base Case
		if(str.substring(lowIndex).length()==0)
			return true;
		for(int i=lowIndex;i<str.length();i++){
			if(dict.contains(str.substring(lowIndex, i+1)) && getWordBreak(str, dict, i+1)==true){
				return true;
			}
		}
		return false;
	}
}