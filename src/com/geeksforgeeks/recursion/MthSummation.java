package com.geeksforgeeks.recursion;

/*Problem: calculate mth summation defined as : 
If m > 1
  SUM(n, m) = SUM(SUM(n, m - 1), 1)
Else 
  SUM(n, 1) = Sum of first n natural numbers

Input 1:
sum(4,1) = 10

Input 2:
sum(3,2) = 21
*/

public class MthSummation {

	public static void main(String[] args) {
		System.out.println(mthSummation(4,1));
		System.out.println(mthSummation(3,2));
		System.out.println(mthSummation(5,3));
	}
	
	// Efficient approach:
	public static int mthSummation(int n,int m){
		if(m>1){
			int sum = mthSummation(n,m-1);
			return (sum*(sum+1))/2;
		}
		else
			return (n*(n+1)/2);
	}
		
	//	My solution
	/*public static int mthSummation(int n,int m){
		if(m>1)
			return mthSummation(mthSummation(n, m-1),1);
		else
			return sumNaturalNumber(n);
	}
	public static int sumNaturalNumber(int n){
		int sum = 0;
		for(int i=1;i<=n;i++)
			sum+=i;
		return sum;
	}*/

}
