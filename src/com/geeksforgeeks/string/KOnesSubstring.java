package com.geeksforgeeks.string;

import java.util.Scanner;

public class KOnesSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<testcases;i++){
			String testcase = sc.nextLine();
			String str = testcase.split(" ")[0];
			int K = Integer.parseInt(testcase.split(" ")[1]);
			getKOnesSubstring(str, K);
		}	
		sc.close();
	}
	
	public static void getKOnesSubstring(String str,int K){
		int count=0,onesCount=0;
		for(int i=0;i<str.length();i++){
			onesCount=0;
			for(int j=i;j<str.length();j++){
				if(str.charAt(j)=='1')
					onesCount++;
				if(onesCount==K){
					count++;
				}
			}
		}
		System.out.println(count);
	}
}