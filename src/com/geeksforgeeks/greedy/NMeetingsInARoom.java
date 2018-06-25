package com.geeksforgeeks.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0
 * This is a variation of activity selection problem
 */

class Meet implements Comparable<Meet>{
	int index, start, end;
	public Meet(int index, int start, int end){
		this.index = index;
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Meet meeting) {
		return this.end - meeting.end;
	}
	
}
public class NMeetingsInARoom {

	public static void main(String[] args) {
		/*int start[] = {1, 3, 0, 5, 8, 5};
		int end[] = {2, 4, 6, 7, 9, 9};*/
		int start[] = {75250,50074,43659,8931,11273,27545,50879,77924};
		int end[] = {112960,114515,81825,93424,54316,35533,73383,160252};
		List<Meet> list = new ArrayList<>();
		for(int i=0;i<start.length;i++)
			list.add(new Meet(i,start[i],end[i]));
		//printList(list);
		Collections.sort(list);
		//System.out.println("After sorting");
		//printList(list);
		maxActivity(list);
	}
	
	public static void maxActivity(List<Meet> list){
		int count = 0;
		int current_act = Integer.MIN_VALUE;
		for(int i=0;i<list.size();i++){
			if(list.get(i).start >= current_act){
				count++;
				current_act = list.get(i).end;
				System.out.print((list.get(i).index + 1) + " ");
			}
		}
		System.out.println("\nTotal activities that are selected : " + count);
	}
	
	public static void printList(List<Meet> list){
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).index + " " + list.get(i).start + " " + list.get(i).end);
	}
}
