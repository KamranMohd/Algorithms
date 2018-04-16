package com.geeksforgeeks.heap;

/**
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 * https://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
 * @author kamran
 *
 */
class MinHeapNode{
	int value;
	int i; 	// Index of array in the given arrays
	int j;	// Index of next element in ith array
	public MinHeapNode(int value,int i,int j){
		this.value = value;
		this.i = i;
		this.j = j;
	}
}

public class MergeKSortedArrays {

	public static void main(String[] args) {
		int mat[][] =  {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
		doMerging(mat);
	}

	private static void doMerging(int [][] mat) {
		int n = mat.length, k = mat[0].length;
		int output[] = new int[n*k];
		MinHeapNode [] heap = new MinHeapNode[n];
		for(int i=0;i<n;i++)
			heap[i] = new MinHeapNode(mat[i][0], i, 1);
		
		//	Create a heap by rearranging the array.
		buildHeap(heap, n);
		
		for(int i=0;i<n*k;i++){
			output[i] = heap[0].value;
			if(heap[0].j < k){
				MinHeapNode nextNode = new MinHeapNode(mat[heap[0].i][heap[0].j], heap[0].i, heap[0].j+1);
				heap[0] = nextNode;
			}
			else
				heap[0] = new MinHeapNode(Integer.MAX_VALUE, -1,-1);
			heapify(heap, 0, n);
		}
		
		//	Print the sorted array
		for(int i=0;i<n*k;i++)
			System.out.print(output[i] + " ");
	}
	
	private static void buildHeap(MinHeapNode[] heap, int k) {
		for(int i=k/2-1;i>=0;i--){
			heapify(heap,i,k);
		}
	}

	private static void heapify(MinHeapNode[] heap, int i, int size) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int min = i;
		if(left < size && heap[left].value < heap[min].value)
			min = left;
		if(right < size && heap[right].value < heap[min].value)
			min = right;
		if(min!=i){
			MinHeapNode temp = heap[min];
			heap[min] = heap[i];
			heap[i] = temp;
			heapify(heap,min,size);
		}
	}
}