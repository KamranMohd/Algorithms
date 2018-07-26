package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/determine-string-unique-characters/
 * Check if the phone number contains all unique digits
 * https://www.geeksforgeeks.org/amazon-interview-experience-set-128-sdet/
 */
public class UniquePhoneNumber {

	public static void main(String[] args) {
		String phoneNumber = "965432134";
		System.out.println(isPhNumUnique(phoneNumber));
	}

	public static boolean isPhNumUnique(String phoneNumber) {
		short checker = 0;
		for (int i = 0; i < phoneNumber.length(); i++) {
			short nthBit = (short)(phoneNumber.charAt(i) - '0');
			// Check if nth bit is already set
			// If yes, then the number is not unique
			if ((checker & 1 << nthBit) > 0)
				return false;
			// Otherwise set the nth bit
			checker = (short)(checker | (1 << nthBit));
		}
		return true;
	}

}
