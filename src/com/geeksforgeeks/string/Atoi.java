package com.geeksforgeeks.string;

/*
 * https://www.geeksforgeeks.org/write-your-own-atoi/
 */
public class Atoi {

	public static void main(String[] args) {
		//String str = "89789";
		//String str = "-123";
		String str = "21a";
		System.out.println("Integer val : " + returnAtoi(str));
	}

	public static int returnAtoi(String str){
		int res = 0, i=0;
		boolean isNeg = false;
		if(str.charAt(i)=='-'){
			isNeg = true;
			i = 1;
		}
		for(;i<str.length();i++){
			if(Character.isDigit(str.charAt(i))==true)
				res = (res * 10)  + str.charAt(i) - '0';
			else
				return -1;
		}	
		return isNeg==true?res*-1:res;
	}
}
