package com.geeksforgeeks.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalToBinary {

	public static void main(String[] args) throws IOException {
		//	Taking input from the user
		System.out.println("Enter the decimal number to convert to binary");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		//int number = 100;
		toBinary(number);
	}
	public static void toBinary(int num){
		if(num==0)
			return;
		toBinary(num/2);
		System.out.print(num%2);
	}
}
