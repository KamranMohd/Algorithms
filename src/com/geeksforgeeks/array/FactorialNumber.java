package com.geeksforgeeks.array;

import java.util.Scanner;

public class FactorialNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		for(int i=0;i<testcases;i++){
			int n = sc.nextInt();
			printFactorial(n);
		}
		sc.close();
	}
	
	public static void printFactorial(int n){
		int i=1,fact=1;
		while(fact<=n){
			System.out.print(fact + " ");
			i++;
			fact*=i;
		}
		System.out.println();
	}
}