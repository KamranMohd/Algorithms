package com.geeksforgeeks.recursion;

//	WAP to print all the binary numbers of n digits
public class PrintAllBinaryNDigits {

	public static void main(String[] args) {
		printBin("",4);
	}
	
	public static void printBin(String temp,int digits){
		if(digits==0){
			System.out.println(temp);
		}else{
			/*
			 * For printing all decimal numbers with 2 digits without the 0
			 * for(int i=1;i<=9;i++)
				printBin(temp+i,digits-1);
			*/
			if(temp.equals(""))
				printBin(temp+"1",digits-1);
			else{
				printBin(temp+"0",digits-1);
				printBin(temp+"1",digits-1);
			}
			
		}
	}
}
