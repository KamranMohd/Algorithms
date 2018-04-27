package com.geeksforgeeks.dp;

public class KnapsackProblem {

	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int W = 50;
	    int size = val.length;
	    long start = System.currentTimeMillis();
	    System.out.println("Maximum value : "  + knapsackRecur(val, wt, size, W));
	    long stop = System.currentTimeMillis();
	    System.out.println("Time taken by recursion is : " + (stop - start));
	    start = System.currentTimeMillis();
	    System.out.println("Maximum value : "  + knapsackDP(val, wt, size, W));
	    stop = System.currentTimeMillis();
	    System.out.println("Time taken by recursion is : " + (stop - start));
	}
	
	public static int knapsackDP(int [] val, int w[], int size, int C){
		int sol[][] = new int[size+1][C+1];
		for(int i=0;i<=size;i++){
			for(int cw=0;cw<=C;cw++){
				if(i==0 || cw==0)
					sol[i][cw] = 0;
				else{
					if(w[i-1] <= cw)
						sol[i][cw] = Math.max(val[i-1] + sol[i-1][cw-w[i-1]], sol[i-1][cw]);
					else
						sol[i][cw] = sol[i-1][cw];
				}
			}
		}
		return sol[size][C];
	}
	
	public static int knapsackRecur(int [] val, int w[], int size, int C){
		//	Base case: When capacity is 0 or size is 0
		if(size==0 || C==0)
			return 0;
		
		//	If the given elements weight exceeds max weight C
		if(w[size-1] > C)
			return knapsackRecur(val, w, size-1, C);
		else 
			return Math.max(val[size-1] + knapsackRecur(val, w, size-1, C-w[size-1]),
					knapsackRecur(val, w, size-1, C));
	}
}