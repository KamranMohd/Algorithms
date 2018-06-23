package com.geeksforgeeks.greedy;

/*
 * https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
 */
import java.util.ArrayList;
import java.util.List;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int den[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int value = 43;
		printDen(den, value);
	}
	
	public static void printDen(int [] den, int value){
		if(value<=0)
			return;
		List<Integer> resultSet = new ArrayList<>();
		for(int i = den.length-1;i>=0;i--){
			//	Loop until the value is greater than the current denomination
			//	Notice that the denomination array is sorted
			while(value >= den[i]){
				value -= den[i];
				resultSet.add(den[i]);
			}
			if(value==0)
				break;
		}
		
		//	Print the result set
		for(int coin : resultSet)
			System.out.print(coin +  " ");
	}

}
