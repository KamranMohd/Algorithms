package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
 */
public class GivenDifferenceBinarySearch {
	public static void main(String[] args) {
	//	int arr[] = {5, 20, 3, 2, 50, 80,100,22};
	//	int arr[] = {90, 70, 20, 80, 50};
	//	int arr[] = {1, 8, 30, 40, 100};
		int arr[] = {1,1,1};
		//int diff = 78;
		int diff = 0;
	//	int diff = 60;
		getPair(arr,diff);
	}
	public static void getPair(int [] arr,int diff){
		int d;
		Map<Integer,Integer> map = new HashMap();
		for(int i=0;i<arr.length;i++){
			d = Math.abs(diff-arr[i]);
			if(map.get(d)!=null)
				System.out.println("(" + d + "," + arr[i] + ")");
			else
				map.put(arr[i], d);
		}
	}
}