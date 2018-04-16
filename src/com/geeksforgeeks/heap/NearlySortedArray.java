package com.geeksforgeeks.heap;

public class NearlySortedArray {

	public static void main(String[] args) {
		int k = 3;
	    int arr[] = {2, 6, 3, 12, 56, 8};
	    sortArray(arr, k);
	}
	
	public static void sortArray(int [] arr, int k){
		int heap[] = new int[k+1];
		for(int i=0;i<=k;i++)
			heap[i] = arr[i];
		
		//	Heapify the array
		for(int i=(k+1)/2-1;i>=0;i--)
			heapify(heap,i,k+1);
		
		int counter = 0;
		for(int i=k+1; i<arr.length; i++){
			arr[counter++] = heap[0];
			heap[0] = arr[i];
			heapify(heap,0,k+1);
		}
		
		for(int i=0;i<=k;i++){
			arr[counter++] = heap[0];
			heap[0] = heap[k-i];
			heapify(heap, 0, k-i);
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void heapify(int [] arr, int i, int size){
		//System.out.println(i);
		int left = 2*i + 1;
		int right = 2*i + 2;
		int min = i;
		if(left < size && arr[left] < arr[min])
			min = left;
		if(right < size && arr[right] < arr[min])
			min = right;
		if(min!=i){
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			heapify(arr, min, size);
		}
	}
	
	public static void printArray(int [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}