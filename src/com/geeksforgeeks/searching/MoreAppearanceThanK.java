package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
 */
public class MoreAppearanceThanK {

	public static void main(String[] args) {
		//int arr[] = {4, 5, 6, 7, 8, 4, 4};
		//int k = 3;
		//int arr[] = {4, 2, 2, 7};
		//int k = 3;
		int arr[] = {2, 7, 2};
		int k = 2;
		getAppearance(arr, k);
	}

	public static void getAppearance(int [] arr, int k){
		Map<Integer,Integer> map = new HashMap();
		for(int i=0;i<arr.length;i++){
			if(map.get(arr[i])==null)
				map.put(arr[i], 1);
			else
				map.put(arr[i],map.get(arr[i])+1);
		}
		
		int appearance = arr.length/k;
		for(Integer key : map.keySet()){
			if(map.get(key) > appearance)
				System.out.println("Element appeared more than " + appearance + " times : " + key + " appeared " + map.get(key) + " times");
		}
	}
}
