package com.geeksforgeeks.searching;

/*
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * Time Complexity = O(n)
 * Space complexity = O(n)
 */
import java.util.Arrays;

public class MissingRepeating2 {

	public static void main(String[] args) {
		//int arr[] = {3, 1, 3};
		int arr[] = {4, 3, 6, 2, 1, 1};
		getMissingRepeating(arr);
	}
	public static void getMissingRepeating(int [] arr){
		boolean temp [] = new boolean[arr.length+1];
		Arrays.fill(temp,false);
		for(int i=0;i<arr.length;i++){
			if(temp[arr[i]]==true)
				System.out.println("Repeating element = " + arr[i]);
			else
				temp[arr[i]]=true;
		}
		for(int i=1;i<temp.length;i++){
			if(temp[i]==false)
				System.out.println("Missing element = " + i);
		}			
	}
}