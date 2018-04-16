package com.geeksforgeeks.heap;

/*
 * https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 */
public class KLargestElement {

	public static void main(String[] args) {
		int arr[] = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		printKLargestElement(arr,k);
	}

	private static void printKLargestElement(int[] arr, int k) {
		int heap[] = new int[k];
		//	Create heap with size k
		for(int i=0;i<k;i++)
			heap[i] = arr[i];
		// 	Heapify the created array
		for(int i=(k/2)-1;i>=0;i--)
			heapify(heap,i);
		//	For every element after k, compare with root node
		for(int i=k;i<arr.length;i++){
			if(heap[0] < arr[i]){
				heap[0] = arr[i];
				heapify(heap, 0);
			}
		}
		//	Print the heap which now has K largest element
		printArray(heap);
		
	}

	public static void heapify(int [] arr, int i){
		//System.out.println(i);
		int left = 2*i + 1;
		int right = 2*i + 2;
		int min = i;
		if(left < arr.length && arr[left] < arr[min])
			min = left;
		if(right < arr.length && arr[right] < arr[min])
			min = right;
		if(min!=i){
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			heapify(arr, min);
		}
	}
	
	public static void printArray(int [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}