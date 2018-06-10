package com.geeksforgeeks.maths;

public class CheckIfLinePassesThroughOrigin {

	public static void main(String[] args) {
		System.out.println(passesThroughOrigin(1, "AA", 2, "AB"));
		System.out.println(passesThroughOrigin(2, "B", 4, "D"));
	}
	public static boolean passesThroughOrigin(int x1, String y1Excel, int x2, String y2Excel){
		int y1 = (y1Excel.length()-1)*26 + (y1Excel.charAt(y1Excel.length()-1)-'A'+1);
		int y2 = (y2Excel.length()-1)*26 + (y2Excel.charAt(y2Excel.length()-1)-'A'+1);
		double slope = (y2-y1)/(x2-x1);
		double intercept = y1 - (slope*x1);
		if(intercept==0)
			return true;
		return false;
	}

}
