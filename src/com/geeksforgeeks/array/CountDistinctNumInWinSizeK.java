package com.geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 */
public class CountDistinctNumInWinSizeK {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		printDistinctCount(arr, k);
	}

	public static void printDistinctCount(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		int unique = 0;
		for (int i = 0; i < k; i++) {
			if (map.get(arr[i]) == null) {
				unique++;
				map.put(arr[i], 1);
			} else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		System.out.println(unique);
		for (int i = k; i < n; i++) {
			if (map.get(arr[i - k]) > 1)
				map.put(arr[i - k], map.get(arr[i - k]) - 1);
			else {
				map.remove(arr[i - k]);
				unique--;
			}
			if (map.get(arr[i]) == null) {
				unique++;
				map.put(arr[i], 1);
			} else
				map.put(arr[i], map.get(arr[i]) + 1);
			System.out.println(unique);
		}
	}

}
