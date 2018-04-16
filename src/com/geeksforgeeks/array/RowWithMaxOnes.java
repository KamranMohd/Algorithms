package com.geeksforgeeks.array;

/**
 * https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 * @author kamran
 *
 */
public class RowWithMaxOnes {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
		System.out.println(getMaxOnesRow(arr, 0, arr.length-1));
	}
	
	public static int getMaxOnesRow(int arr[][], int low, int high){
		int maxIndex = -1, index, maxZeros = 0;
		for(int i=0;i<=high;i++){
			index = firstOneIndex(arr[i],low,high);
			if(index!=-1 && (high-index+1)>maxZeros){
				maxZeros = high-index+1;
				maxIndex = i;
			}
		}
		System.out.print("Maximum ones are : " + maxZeros + " at row index : ");
		return maxIndex;
	}

	private static int firstOneIndex(int[] arr, int low, int high) {
		while(high>=low){
			int mid = low + (high-low)/2;
			if((mid==0 || arr[mid-1]==0) && arr[mid]==1)
				return mid;
			else if(arr[mid]==0)
				return firstOneIndex(arr,mid+1,high);
			else
				return firstOneIndex(arr,low,mid-1);
		}
		return -1;
	}
}