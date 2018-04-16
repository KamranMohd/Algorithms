package com.geeksforgeeks.recursion;

/*
 * Given a number n, our task is to find all 1 to n bit numbers with no consecutive 1s in their binary representation.
 * Input : n = 4
 * Output : 1 2 4 5 8 9 10
 * These are numbers with 1 to 4
 * bits and no consecutive ones in
 * binary representation.
 * http://www.geeksforgeeks.org/1-to-n-bit-numbers-with-no-consecutive-1s-in-binary-representation/
 */
public class NoConsOnesBinary {

	public static void main(String[] args) {
		printNumber(0,"",4);
	}

	public static void printNumber(int currentDigits,String number,int totalDigits){
		if(currentDigits>totalDigits)
			return;
		if(currentDigits!=0)
			System.out.println(number);
		if(number.equals(""))
			printNumber(currentDigits+1, number+"1", totalDigits);
		else if(number.charAt(number.length()-1)=='1')
			printNumber(currentDigits+1, number+"0", totalDigits);
		else if(number.charAt(number.length()-1)=='0'){
			printNumber(currentDigits+1, number+"1", totalDigits);
			printNumber(currentDigits+1, number+"0", totalDigits);
		}		
	}
}