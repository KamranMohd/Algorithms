package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
public class MinimumJumps {

	public static void main(String[] args) {
		//int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int arr[] = {1, 3, 6, 1, 0, 9};
		//int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println("Minimum jumps required usign recursion : " + minJumps(arr, 0, arr.length - 1));
		System.out.println("Minimum jumps required usign DP : " + minJumpsDp(arr, arr.length));
	}

	/*
	 * Method 1 : Recursive approach
	 */
	public static int minJumps(int[] arr, int l, int h) {
		if (l == h)
			return 0;
		if (arr[l] == 0)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int jumps = minJumps(arr, i, h);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}
		return min;
	}

	/*
	 * Method 2: Using Dynamic Programming
	 */

	public static int minJumpsDp(int arr[], int n) {
		// Create jumps[], such that jumps[i] denotes the
		// min number of jumps required to reach i from 0
		int jumps[] = new int[n];

		//	Create an array that holds the actual path
		int path[] = new int[n];
		//	Since we start from zero
		path[0] = -1;
		
		// If the first step is 0, then we can't move forward
		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		// Since, jumps required to reach start is 0
		jumps[0] = 0;

		// Now check for all i greater than 1
		for (int i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			// Iterate through 0 to i-1 to count the min
			// jumps required to reach i from 0
			for (int j = 0; j < i; j++) {
				// i is reachable from j only when j+arr[j]>=i
				if (j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE) {
					// Assign minimum jumps to jumps[i]
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					path[i] = j;	
					// The reason we break here is that jumps[j]<=jumps[j+1]
					// since jumps[j] holds minimum steps to reach j, therefore
					// jumps[j+1] will never be less than jumps[j], hence no
					// need to check further
					break;
				}
			}
		}
		
		//	Print the path for the minimum jumps to reach the end
		System.out.println("Path from source to destination using the minimum jumps");
		for(int i=1;i<n;i++){
			if(path[i]!=path[i-1])
				System.out.print(path[i] + " -> ");
		}
		System.out.println(n-1);
		return jumps[n - 1];
	}

}
