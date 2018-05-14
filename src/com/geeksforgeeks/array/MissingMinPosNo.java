package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 */

public class MissingMinPosNo {

	public static void main(String[] args) {
		//int arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 };
		//int arr[] = { 2, 3, -7, 6, 8, 1 , -10, 15 };
		int [] arr = {1, 1, 0, -1, -2};
		printMissingSmallest(arr);
	}

	public static void printMissingSmallest(int arr[]) {
		int startIndex = segregate(arr);
		int[] modArr = new int[arr.length - startIndex];
		for (int i = startIndex, j = 0; i < arr.length; i++, j++)
			modArr[j] = arr[i];
		int size = modArr.length;
		for (int i = 0; i < size; i++) {
			if ((Math.abs(modArr[i]) - 1) < size && modArr[Math.abs(modArr[i]) - 1] > 0)
				modArr[Math.abs(modArr[i]) - 1] = -modArr[Math.abs(modArr[i]) - 1];
		}
		for (int i = 0; i < size; i++) {
			if (modArr[i] > 0) {
				System.out.println(i + 1);
				return;
			}
		}
		//System.out.println(size + 1);
	}

	/*
	 * Put all the non positive number at the start of the array
	 */
	private static int segregate(int[] arr) {
		int startPos = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				int temp = arr[i];
				arr[i] = arr[startPos];
				arr[startPos] = temp;
				startPos++;
			}
		}
		for(int i : arr)
			System.out.print(i +  " ");
		System.out.println();
		return startPos;
	}
}
