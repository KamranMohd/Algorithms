package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
 */
public class OptimalGamingStrategy {

	public static void main(String[] args) {
		int arr[] = {5, 3, 7, 10};
		//int arr[] = {8, 15, 3, 7 };
		System.out.println(getMaxVal(arr, 0, arr.length-1));
		System.out.println(getMaxValDP(arr,arr.length));
	}
	
	public static int getMaxValDP(int [] arr, int n){
		//	Create a table[][] such that table[i][j] holds the max
		//	val that user 1 can get if there was coins from index i to index j
		int table[][] = new int[n][n];
		int x,y,z;
		//	gap variable defines the number of coins that we
		//	consider and it ranges from 1 coin -> 2coin -> and so on
		for(int gap=0;gap<n;gap++){
			// For each gap consider the starting pos i and ending pos j
			for(int i=0,j=gap;i<n && j<n;i++,j++){
				//	refer the recursive solution below to see 
				//	why we are calculating these values;
				//	we check if the table[i+2][j] is filled
				//	else we assign 0
				x = (i+2<=j)?table[i+2][j]:0;
				y = (i+1<=j-1)?table[i+1][j-1]:0;
				z = (i<=j-2)?table[i][j-2]:0;
				table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z)) ;
			}
		}
		//	We return the value when coins are from index to n-1
		return table[0][n-1];
	}
	
	public static int getMaxVal(int [] arr, int i, int j){
		if(i==j)
			return arr[i];
		if(i+1==j)
			return Math.max(arr[i],arr[j]);
		return Math.max(arr[i]+Math.min(getMaxVal(arr,i+1,j-1), getMaxVal(arr,i+2,j)), 
				arr[j]+Math.min(getMaxVal(arr,i+1,j-1), getMaxVal(arr,i,j-2)));
	}
	
	

}
