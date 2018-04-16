package com.geeksforgeeks.sorting;

/*
 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. 
 * Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
 * http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 * If array elements are not distinct, then other methods are used. Refer the link above
 */
import java.util.HashMap;
import java.util.Map;

public class ArraySubset {

	public static void main(String[] args) {
		//int arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1};
		//int arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4};
		int arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3};
		isSubset(arr1, arr2);
	}

	public static void isSubset(int [] arr1,int arr2[]){
		boolean isSubset = true;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr1.length;i++)
			map.put(arr1[i],1);
		for(int i=0;i<arr2.length;i++){
			if(map.get(arr2[i])==null){
				isSubset = false;
				break;
			}
		}
		System.out.println("Is arr2 subset of arr1 : " + (isSubset==false?"No":"Yes"));
	}
}
