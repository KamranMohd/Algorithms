package com.geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1/
 * https://www.geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1-set-2/
 */
public class SubseqWithDiff0or1 {

	public static void main(String[] args) {
		int arr[] = {2, 5, 6, 3, 7, 6, 5, 8};
		//int arr[] = {-2, -1, 5, -1, 4, 0, 3};
		System.out.println("LIS using DP is : " + getMaxSubseq(arr));
		System.out.println("LIS using Opt is : " + getMaxSubseq(arr));
	}
	
	/*
	 * Method 1: Using dp
	 * Space complexity : O(n)
	 * Time complexity : O(n2)
	 */
	public static int getMaxSubseq(int [] arr){
		int n = arr.length;
		int dp[] = new int[n];
		
		//	Initialize the value
		for(int i=0;i<n;i++)
			dp[i] = 1;
		
		//	Check for all indexes and update the dp[]
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(Math.abs(arr[i]-arr[j])<=1 && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
			}
		}
		
		//	Find max and return
		int max = 0;
		for(int i=0;i<n;i++){
			if(dp[i] > max)
				max = dp[i];
		}
		return max;
	}
	
	/*
	 * Method 2: Using hashmap
	 * Space complexity : O(n)
	 * Time complexity : O(n)
	 */
	public static int getMaxSubseqOpt(int [] arr){
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		int result = 0;
		for(int i=0;i<n;i++){
			int len = 0;
			if(map.containsKey(arr[i]-1) && len < map.get(arr[i]-1))
				len = map.get(arr[i]-1);
			if(map.containsKey(arr[i]) && len < map.get(arr[i]))
				len = map.get(arr[i]);
			if(map.containsKey(arr[i]+1) && len < map.get(arr[i]+1))
				len = map.get(arr[i]+1);
			map.put(arr[i],len+1);
			if(map.get(arr[i]) > result)
				result = map.get(arr[i]);
		}
		return result;
	}

}
