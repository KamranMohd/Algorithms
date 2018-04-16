package com.geeksforgeeks.searching;
/*
 * http://www.geeksforgeeks.org/majority-element/
 */
public class MajorityAlgorithm {
	public static void main(String[] args) {
		int arr[] = {1, 3, 3, 1, 2};
		int majorityElement = getMajorityElement(arr);
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==majorityElement)
				count++;
		}
		if(count>=arr.length/2)
			System.out.println("Majority Element is : " + majorityElement);
		else
			System.out.println("No majority element found");
	}
	public static int getMajorityElement(int [] arr){
		int maxIndex = 0, count = 1;
		for(int i=1;i<arr.length;i++){
			if(arr[i]==arr[maxIndex])
				count++;
			else
				count--;
			if(count==0){
				maxIndex++;
				count = 1;
			}
		}
		return arr[maxIndex];
	}
}
