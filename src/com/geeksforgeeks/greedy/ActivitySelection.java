package com.geeksforgeeks.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0.
 * Refer NMeetingsInARoom.java file for sorting implementation
 */

class Meeting implements Comparable<Meeting>{
	int startTime,endTime;
	public Meeting(int startTime, int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int compareTo(Meeting meeting) {
		return this.endTime - meeting.endTime;
	}
}


public class ActivitySelection {

	public static void main(String[] args) {
		//int start[] =  {1, 3, 0, 5, 8, 5};
	    //int finish[] =  {2, 4, 6, 7, 9, 9};
		/*int start[]  =  {10, 12, 20};
	    int finish[] =  {20, 25, 30};*/
		List<Meeting> list = new ArrayList<>();
		list.add(new Meeting(12,25));
		list.add(new Meeting(10,20));
		list.add(new Meeting(20,30));
	    System.out.println("Non sorted list");
	    printList(list);
	    System.out.println("Sorted list");
	    Collections.sort(list);
	    printList(list);
		//maxActivity(start, finish);
	}
	
	/*
	 *	Assumption: The activities are sorted by their finish time. If the activities are not 
	 *	sorted by finish time, we can do that first and then proceed
	 */
	public static void maxActivity(int [] start, int [] finish){
		int count = 0;
		int current_act = Integer.MIN_VALUE;
		for(int i=0;i<start.length;i++){
			if(start[i] >= current_act){
				count++;
				current_act = finish[i];
				System.out.print(i + " ");
			}
		}
		System.out.println("\nTotal activities that are selected : " + count);
	}
	
	public static void printList(List<Meeting> list){
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).startTime + " " + list.get(i).endTime);
	}

}
