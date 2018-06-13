package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 */

public class MinDiffSumPartition {

	public static void main(String[] args) {
		//int arr[] = {3, 1, 4, 2, 2, 1};
		int arr[] = {12, 31};
        int n = arr.length;
        System.out.println ("The minimum difference between 2 sets is "
                            + minDifferenceSubset(arr, n));
	}
	
	public static int minDifferenceSubset(int [] arr, int n){
		//	Calculate the total sum
		int total = 0;
		for(int i:arr)
			total+=i;
		
		//	Create a table dp[i][j] such that it holds the true if sum i
		//	can be achieved using the subset arr[0..j-1]
		boolean dp[][] = new boolean[n+1][total+1];
		
		//	If the sum is zero, then it can be made with all the numbers
		for(int i=0;i<=n;i++)
			dp[i][0] = true;
		
		//	If no element, then no sum except 0 can be created
		for(int i=1;i<=total;i++)
			dp[0][i] = false;
		
		//	Iterate through each element and check if it possible
		//	to get the sum
		for(int i=1;i<=n;i++){
			for(int j=1;j<=total;j++){
				//	If the current element is greater than the current sum,
				//	the element can't be included
				if(arr[i-1] > j)
					dp[i][j] = dp[i-1][j];
				
				//	Now the element can either be included or excluded
				else
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				
				
			}
		}
		
		int minDiff = Integer.MAX_VALUE;
		//	The minimum value will be achieved, if the sum can be equally divided among 
		//	2 subsets
		for(int i=total/2;i>=0;i--){
			//	If a subset is possible with current sum, we calculate the diff
			//	between this subset and the other subset
			//	The reason we break is that the closer the sum with sum/2, lesser the
			//	difference, so lower sum will not fetch us the min diff
			if(dp[n][i]==true){
				minDiff = Math.min(minDiff, Math.abs((total-i) - i));	
				break;
			}
					
		}
		return minDiff;
	}
}
