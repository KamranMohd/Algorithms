package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 */
public class KthElementIn2SortedArr {

	public static void main(String[] args) {
		int a1[] = {2, 3, 6, 7, 9};
        int a2[] = {1, 4, 8, 10};
        int k = 5;
        System.out.print(kthElement(a1, a2, 0, 5, 0, 4, k));
	}
	
	/*
	 *	Method 1: Dividing the 2 arrays from center and then comparing 
	 *		      their values to see if there are eligible or not 
	 */
	public static int kthElement(int [] a1, int[] a2, int l1, int r1, int l2, int r2, int k){
		//	If the a1 is empty
	    if(l1>r1)
	        return a2[l2 + k-1];
	    //	If the a2 is empty
	    if(l2>r2)
	        return a1[l1 + k-1];
	    
	    //	calculate the midpoints of 2 arrays
	    int m1 = l1 + (r1-l1)/2;
	    int m2 = l2 + (r2-l2)/2;
	    //	Find the no of elements from lower index to mid index
	    int e1 = m1 - l1 + 1;
	    int e2 = m2 - l2 + 1;
	    
	    if(e1+e2<=k){
	        if(a1[m1] < a2[m2])
	            return kthElement(a1,a2,m1+1,r1,l2,r2,k-e1);
	        return kthElement(a1,a2,l1,r1,m2+1,r2,k-e2);
	    }
	    else{
	        if(a1[m1] > a2[m2])
	            return kthElement(a1,a2,l1,m1-1,l2,r2,k);
	        return kthElement(a1,a2,l1,r1,l2,m2-1,k);
	    }
	}

}
