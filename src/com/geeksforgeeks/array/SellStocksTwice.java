package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 */
public class SellStocksTwice {

	public static void main(String[] args) {
        //int price[] = {2, 30, 15, 10, 8, 25, 80};
		int price[] = {90, 80, 70, 60, 50};
        int n = price.length;
        System.out.println("Maximum profit : " + getMaxProfit(price, n));
	}
	
	public static int getMaxProfit(int [] price, int n){
		//	Create a profit array and initialize with zero
		int profit[] = new int[n];
		for(int i=0;i<n;i++)
			profit[i] = 0;
		
		//	Move right to left and find max profit[i] 
		//	price[i+1...n-1]
		int max = price[n-1];
		for(int i=n-2;i>=0;i--){
			if(price[i] > max)
				max = price[i];
			profit[i] = Math.max(profit[i+1], max - price[i]);
		}
		
		//	Move left to right and do the same
		int min = price[0];
		for(int i=1;i<n;i++){
			if(price[i] < min)
				min = price[i];
			profit[i] = Math.max(profit[i-1], profit[i] + (price[i]-min));
		}
		return profit[n-1];
		
	}

}
