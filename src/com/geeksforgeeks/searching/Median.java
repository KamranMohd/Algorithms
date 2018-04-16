package com.geeksforgeeks.searching;
/*
 * WAP to find the median of 2 sorted arrays
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class Median {

	public static void main(String[] args) {
		int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45};
	    System.out.println(getMedian(ar1, ar2));
	}
	
	public static int getMedian(int [] arr1,int [] arr2){
		int mp1 = arr1.length-1,mp2 = arr2.length;
		int low1=0,low2=0,high1=arr1.length-1,high2=arr2.length-1;
		int currentInd=0,median=0;
		while(low1<=high1 && low2<=high2){
			if(arr1[low1]<=arr2[low2]){
				if(currentInd==mp1 || currentInd==mp2)
					median+=arr1[low1];
				low1++;
			}
			else{
				if(currentInd==mp1 || currentInd==mp2)
					median+=arr2[low2];
				low2++;
			}
			currentInd++;
		}
		while(low1<=high1){
			if(currentInd==mp1 || currentInd==mp2)
				median+=arr1[low1];
			low1++;
			currentInd++;
		}
		while(low2<=high2){
			if(currentInd==mp1 || currentInd==mp2)
				median+=arr2[low2];
			low2++;
			currentInd++;
		}
		return (median/2);
	}

}
