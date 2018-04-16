package com.geeksforgeeks.searching;

public class SmallestMissingNumberOptimized {

	public static void main(String[] args) {
		int arr[] = {2, 3, 7, 6, 8, -1, -10, 15};
	//	int [] arr = { 2, 3, -7, 6, 8, 1, -10, 15,0};
		int lowInd = segregate(arr);
		int posArr[] = new int[arr.length-lowInd];
		System.out.println(findMissing(arr,posArr,lowInd));
	}
	
	private static int findMissing(int arr[],int[] posArr, int lowInd) {
		for(int i=0;i<posArr.length;i++){
			posArr[i] = arr[lowInd];
			lowInd++;
		}
		//printArr(posArr);
		for(int i=0;i<posArr.length;i++){
			if(Math.abs(posArr[i])-1 < posArr.length && posArr[Math.abs(posArr[i])-1] > 0)
				posArr[Math.abs(posArr[i])-1] = -posArr[Math.abs(posArr[i])-1];
		}
		for(int i=0;i<posArr.length;i++){
			if(posArr[i] > 0)
				return i+1;
		}
		return 1;
	}

	private static int segregate(int [] arr){
		int low = 0,high = arr.length-1;
		while(low<high){
			while(arr[low] <= 0)
				low++;
			while(arr[high] > 0)
				high--;
			if(low<high){
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		return low;
	}
}