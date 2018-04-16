package com.geeksforgeeks.recursion;

/*
 * WAP to print all N digits binary numbers with more 1s than 0s
 * http://www.geeksforgeeks.org/print-n-bit-binary-numbers-1s-0s-prefixes/
 */

public class BinaryNoWithMore1s {

	public static void main(String[] args) {
		printNumber(4,4,"",0);
	}
	
	public static void printNumber(int currentDigits, int totalDigits, String num, int onesCount){
		if(currentDigits==0){
			if(onesCount>=(totalDigits-onesCount))
				System.out.println(num);
			return;
		}
		if(num.equals(""))
			printNumber(currentDigits-1, totalDigits, num + "1", onesCount+1);
		else{
			printNumber(currentDigits-1, totalDigits, num + "1", onesCount+1);
			printNumber(currentDigits-1, totalDigits, num + "0", onesCount);
		}
	}

}
