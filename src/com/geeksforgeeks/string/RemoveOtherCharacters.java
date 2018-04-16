package com.geeksforgeeks.string;

public class RemoveOtherCharacters {

	public static void main(String[] args) {
		printString("!@#$%^&*()_+");
	}
	
	public static void printString(String str){
		StringBuffer onlyChars = new StringBuffer("");
		for(int i=0;i<str.length();i++){
			int ascii = (int)str.charAt(i);
			if((ascii>=65 && ascii<=90) || (ascii>=97 && ascii<=122))
				onlyChars.append(str.charAt(i));
		}
		if(onlyChars.length()==0)
			System.out.println("-1");
		else
			System.out.println(onlyChars);
	}
}