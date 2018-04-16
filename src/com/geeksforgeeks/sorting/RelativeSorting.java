package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class RelativeSorting {

	public static void main(String[] args) {
		int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int A2[] = {2, 1, 8, 3};
		doRelativeSort(A1, A2);
		for(int i=0;i<A1.length;i++)
			System.out.print(A1[i] + " ");
	}
	
	public static void doRelativeSort(int [] arr1,int arr2[]){
		int [] temp = new int[arr1.length];
		int [] visited = new int[arr1.length];
		for(int i=0;i<arr1.length;i++){
			temp[i] = arr1[i];
			visited[i] = 0;
		}
		int k=0;
		Arrays.sort(temp);
		for(int i=0;i<arr2.length;i++){
			int firstIndex = firstOccurence(temp, 0, temp.length-1, arr2[i]);
			//System.out.println(firstIndex);
			if(firstIndex!=-1){
				for(int j=firstIndex;(temp[j]==arr2[i] && j<temp.length);j++){
					arr1[k] = temp[j];
					visited[j] = 1;
					k++;
				}
			}
		}
		//System.out.println(k);
		for(int i=0;i<visited.length;i++){
			if(visited[i]==1)
				continue;
			arr1[k] = temp[i];
			k++;
		}
			
	}
	public static int firstOccurence(int [] arr,int low,int high,int toSearch){
		if(high>=low){
			int mid = low + (high-low)/2;
			if((mid==0 || toSearch > arr[mid-1]) && arr[mid]==toSearch){
				return mid;
			}else if(toSearch > arr[mid]){
				return firstOccurence(arr, mid+1, high, toSearch);
			}else{
				return firstOccurence(arr, low, mid-1, toSearch);
			}
		}
		return -1;
	}
}