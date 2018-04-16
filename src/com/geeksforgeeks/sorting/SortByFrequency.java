package com.geeksforgeeks.sorting;

import java.util.HashMap;
import java.util.Map;

public class SortByFrequency {

	public static void main(String[] args) {
		
	}

	public static void getFrequency(int [] arr){
		Map<Integer,Integer> frequencyMap = new HashMap<>();
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(frequencyMap.get(arr[i])!=null)
				frequencyMap.put(arr[i], frequencyMap.get(arr[i])+1);
			else{
				frequencyMap.put(arr[i], 1);
				indexMap.put(arr[i], i);
			}
		}
	}
}