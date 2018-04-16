package com.geeksforgeeks.array;

/*
 * Consider a big party where a log register for guest’s entry and exit times is maintained. 
 * Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
 * http://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
 */
import java.util.Arrays;

public class MaximumGuest {

	public static void main(String[] args) {
		//int entry[] = {1, 2, 9, 5, 5};
	    //int exit[] = {4, 5, 12, 9, 12};
		//int entry [] = {13, 28, 29, 14, 40, 17, 3}; 
		//int exit [] = {107, 95, 111, 105, 70, 127, 74};
		int entry[] = {1, 2, 10, 5, 5};
		int exit[]	=	{4, 5, 12, 9, 12};
	    findMaximumGuestTime(entry, exit);
	}
	
	public static void findMaximumGuestTime(int [] entry, int [] exit){
		int j=0,curG=0,maxG=-1,maxT=0;
		Arrays.sort(entry);
		Arrays.sort(exit);
		for(int i=0;i<exit.length;i++){
			while((j<entry.length) && entry[j]<=exit[i]){
				curG++;j++;
			}
			if(curG > maxG){
				maxG = curG;
				maxT = entry[j-1];
			}
			curG--;
		}
		System.out.println("Max guest were : " + maxG + " at time : " + maxT);
	}
}