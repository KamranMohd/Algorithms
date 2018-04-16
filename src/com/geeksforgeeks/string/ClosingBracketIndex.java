package com.geeksforgeeks.string;

public class ClosingBracketIndex {

	public static void main(String[] args) {
		String str = "[ABC[23]][89]";
		int startIndex = 0;
		System.out.println(getClosingBracketIndex(str, startIndex));
	}
	
	private static int getClosingBracketIndex(String str,int startIndex){
		int bracketCount=0,lastIndex=-1;
		for(int i=startIndex;i<str.length();i++){
			if(str.charAt(i)=='[')
				bracketCount++;
			else if(str.charAt(i)==']')
				bracketCount--;
			if(bracketCount==0){
				lastIndex = i;
				break;
			}
				
		}
		return lastIndex;
	}
}