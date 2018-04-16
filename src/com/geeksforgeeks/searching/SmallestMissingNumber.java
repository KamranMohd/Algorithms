package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

public class SmallestMissingNumber {

	public static void main(String[] args) {
	//	int arr[] = {2, 3, 7, 6, 8, -1, -10, 15};
		int [] arr = { 2, 3, -7, 6, 8, 1, -10, 15 };
		System.out.println(findMissing(arr));
	}
	
	public static int findMissing(int [] arr){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++)
			map.put(arr[i], 1);
		boolean found = false;
		int j=1;
		while(found==false){
			if(map.get(j)==null)
				found = true;
			j++;
		}
		return j-1;
	}
}