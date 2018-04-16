package com.geeksforgeeks.recursion;

//Given a number n, we need to print all n-digit binary numbers with equal sum in left and right halves. 
//If n is odd, then mid element can be either 0 or 1.
//http://www.geeksforgeeks.org/all-possible-binary-numbers-of-length-n-with-equal-sum-in-both-halves/ 
public class BinaryEqualHalvesEfficient {

	public static void main(String[] args) {
		printOutput(5,"","",0);
	}

	public static void printOutput(int digits,String lh,String rh,int diff) {
		//	If happen only if the digits are even in number
		if(digits==0){
			if(diff==0)
				System.out.println(lh+rh);
			return;
		}
		//	This will happen only if the digits are odd in number
		if(digits==1){
			if(diff==0){
				System.out.println(lh+"0"+rh);
				System.out.println(lh+"1"+rh);
			}
			return;
		}
		
		if(!lh.equals("")){
			printOutput(digits-2,lh+"0",rh+"0",diff);
			printOutput(digits-2,lh+"0",rh+"1",diff+1);
		}
		printOutput(digits-2,lh+"1",rh+"0",diff-1);
		printOutput(digits-2,lh+"1",rh+"1",diff);
	}
}