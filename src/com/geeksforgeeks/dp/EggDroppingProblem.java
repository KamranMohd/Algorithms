package com.geeksforgeeks.dp;

/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDroppingProblem {

	public static void main(String[] args) {
		//int n = 2, k = 10;
		int n=2,k=100;
		//System.out.println("Recursion : Minimum number of trials in worst case with " + n + " eggs and "
	    //        + k + " floors is : " + eggDrop(n, k));
		System.out.println("DP : Minimum number of trials in worst case with " + n + " eggs and "
	             + k + " floors is : " + eggDropDP(n, k));
	}
	/*
	 * Method 2: Dynammic Programming
	 */
	
	public static int eggDropDP(int n, int k){
		//	Create a table[][] such that table[i][j] holds the trial
		//	needed for i eggs and j floors
		int dp[][] = new int[n+1][k+1];
		
		//	Boundary cond 1: If the floors are 0, 0 trials needed and if
		//	floor is 1, 1 trial is needed
		for(int i=1;i<=n;i++){
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		//	Boundary cond 2: If the egg is 1, trials needed equal to k
		for(int i=1;i<=k;i++)
			dp[1][i] = i;
		
		//	Fill in the values in bottom up manner
		for(int i=2;i<=n;i++){
			for(int j=2;j<=k;j++){
				dp[i][j] = Integer.MAX_VALUE;
				//	Find the value for i eggs and j floors
				for(int x=1;x<=j;x++){
					int res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
					dp[i][j] = Math.min(dp[i][j], res);
				}
			}
		}
		return dp[n][k];
	}
	
	/*
	 * Method 1: recursive approach
	 */
	
	public static int eggDrop(int n, int k){
		//	n eggs and k floors
		//	Base condition 1: If floors is 1 or 0, trials needed will be 1
		//	or 0 respectively
		if(k==0 || k==1)
			return k;
		
		//	Base condition 2: if there is 1 egg and k floors, trials needed is k
		if(n==1)
			return k;
		
		int maxTrials, res = Integer.MAX_VALUE;
		//	Iterate egg dropping from all the floors
		for(int i=2;i<=k;i++){
			//	there are 2 conditions a) egg breaks b) egg does not break
			maxTrials = Math.max(eggDrop(n-1, i-1), eggDrop(n, k-i));
			res = Math.min(res, maxTrials);
		}
		return res + 1;
	}

}
