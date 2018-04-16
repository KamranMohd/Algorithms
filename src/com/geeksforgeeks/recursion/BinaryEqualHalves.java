package com.geeksforgeeks.recursion;

//Given a number n, we need to print all n-digit binary numbers with equal sum in left and right halves. 
//If n is odd, then mid element can be either 0 or 1.
public class BinaryEqualHalves {

	public static void main(String[] args) {
		printOutput("",4,4);
	}
	public static void printOutput(String temp, int totalDigits, int currentDigits){
		if(currentDigits==0){
			printDesiredOutput(temp,totalDigits);
		}
		else{
			printOutput(temp+"0",totalDigits,currentDigits-1);
			printOutput(temp+"1",totalDigits,currentDigits-1);
		}
	}

	public static void printDesiredOutput(String temp, int totalDigits) {
		String rightHalf = temp.substring((totalDigits-1)/2 + 1);
		String leftHalf = temp.substring(0, (totalDigits)/2);
		if(sum(rightHalf)==sum(leftHalf) && temp.charAt(0)!='0')
			System.out.println(temp);
	}

	public static int sum(String rightHalf) {
		int sum=0;
		for(int i=0;i<rightHalf.length();i++)
			sum+=Integer.parseInt((String.valueOf(rightHalf.charAt(i))));
		return sum;
	}
}
