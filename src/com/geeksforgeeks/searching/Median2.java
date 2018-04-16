package com.geeksforgeeks.searching;

import java.util.Arrays;

/*
 * WAP to find the median of 2 sorted arrays of equal size
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class Median2 {

	public static void main(String[] args) {
		/*int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45};*/
		int ar1[] = {2,4,6,8,10,12};
		int ar2[] = {1,3,5,7,9,11};
		/*int ar1[] = {1, 2, 3, 6};
	    int ar2[] = {4, 6, 8, 10};*/
	    System.out.println("Median : " + getMedian(ar1, ar2,ar1.length));
	}
	
	public static int getMedian(int [] arr1,int [] arr2,int length){
		if(length<1)
			return -1;
		else if(length==1)
			return (arr1[0] + arr2[0])/2;
		else if(length==2)
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1]))/2;
		
		//		Get the median of 2 sorted arrays independently
		int m1 = getIndividualMedian(arr1);
		int m2 = getIndividualMedian(arr2);
		
		//	If median is equal, return any one
		if(m1==m2)
			return m1;
		//	Check which one is bigger and decide
		else if(m1 < m2){
			if(length%2 == 0)
				return getMedian(Arrays.copyOfRange(arr1, length/2, length), Arrays.copyOfRange(arr2,0,length/2), length/2);
			return getMedian(Arrays.copyOfRange(arr1, length/2, length), Arrays.copyOfRange(arr2,0,length/2+1), length/2+1);
		}
		else{
			if(length%2 == 0)
				return getMedian(Arrays.copyOfRange(arr1,0,length/2), Arrays.copyOfRange(arr2,(length/2),length), length/2);
			return getMedian(Arrays.copyOfRange(arr1,0,length/2+1), Arrays.copyOfRange(arr2,length/2,length), length/2+1); 
		}
	}
	
	public static int getIndividualMedian(int [] arr){
		int median,arrSize = arr.length;
		median = arrSize%2==0 ? (arr[arrSize/2] + arr[(arrSize-1)/2])/2: (arr[arrSize/2]);
		return median;
	}
}