package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/amazon-interview-set-51-campus-sdet/
 */
public class BettingGame {

	public static void main(String[] args) {
		String str = "WLWWL";
		int intialSum = 10;
		findFinalAmount(str, intialSum);
	}
	
	public static void findFinalAmount(String str, int sum){
		int bet = 1;
		for(int i=0;i<str.length();i++){
			if(i!=0 && sum==0)
				return;
			if(str.charAt(i)=='W'){
				sum += bet;
				bet = 1;
			}
			else{
				sum -= bet;
				bet = 2*bet;
			}
		}
		System.out.println("Final amount : " + sum);
	}
}