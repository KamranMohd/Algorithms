package com.geeksforgeeks.greedy;

/*	Incomplete solution, since the output is not clear.
 * https://practice.geeksforgeeks.org/problems/geek-collects-the-balls/0
 */
public class CollectMaxBalls {

	public static void main(String[] args) {
		//int r1[] = { 1, 2, 3, 4, 5, 6, 6, 7 };
		//int r2[] = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7 };
		int r1[] = {1,4,5,6,8};
		int r2[] = {2,3,4,6,9};
		int n = r1.length;
		int m = r2.length;
		System.out.println(getMaxBalls(r1, r2, n, m));
	}

	public static int getMaxBalls(int[] r1, int[] r2, int n, int m) {
		// Create sum arrays for both r1 and r2 where s1[i]
		// holds the sum for r1[0..i]
		int sum1[] = new int[n];
		sum1[0] = r1[0];
		int sum2[] = new int[m];
		sum2[0] = r2[0];
		for (int i = 1; i < n; i++)
			sum1[i] = sum1[i - 1] + r1[i];
		for (int i = 1; i < m; i++)
			sum2[i] = sum2[i - 1] + r2[i];

		printArr(r1);
		printArr(r2);
		System.out.println();
		printArr(sum1);
		printArr(sum2);
		// Initialize starting and ending index for both the arrays
		int s1 = 0, e1 = 0, s2 = 0, e2 = 0, total = 0;
		for (int i = 0; i < n; i++) {
			if (i + 1 < n && r1[i + 1] == r1[i]) {
				total += r1[i];
				s1++;
				continue;
			}
			
			e2 = binarySearch(r2, 0, m - 1, r1[i]);
			System.out.println("Searching for element : " + r1[i] + " s2 = " + s2 + " index = " + e2);
			// If the element is found
			if (e2 != -1) {
				int diff1 = (s1 == i) ? sum1[s1] : sum1[i] - sum1[s1];
				int diff2 = (s2 == e2) ? sum2[s2] : sum2[e2] - sum2[s2];
				System.out.println("s1 = " + s1 + " s2 = " + s2 + " e1 = " + i
						+ " e2 = " + e2 + " diff1 = " + diff1 + " diff2 = "
						+ diff2 + " toSearch = " + r1[i]);
				if (diff2 > diff1)
					total += diff2;
				else
					total += diff1;
				s1 = i;
				s2 = e2;
				System.out.println("total = " + total);
			}
			System.out.println();
		}
		total += Math.max(sum1[n - 1] - sum1[s1], sum2[m - 1] - sum2[s2]);
		return total;
	}

	/*
	 * public static int getMaxBalls(int[] r1, int[] r2, int n, int m) { int s1
	 * = 0, e1 = 0, s2 = 0, e2 = 0; int max = 0, r1_sum = 0, r2_sum; for (int i
	 * = 0; i < n; i++) { r1_sum += r1[i]; e1++; if(i+1 < n && r1[i+1]==r1[i]){
	 * max += r1_sum; continue; }
	 * 
	 * e2 = binarySearch(r2, s2, m - 1, r1[i]); if (e2 != -1) { r2_sum =
	 * getSum(r2, s2, e2); // System.out.println(r2_sum + " " + r1_sum); s2 = e2
	 * + 1; max += Math.max(r1_sum, r2_sum); s1 = i + 1; r1_sum = 0; } } //
	 * System.out.println(s2); r2_sum = getSum(r2, s2, m - 1); //
	 * System.out.println(r2_sum); max += Math.max(r1_sum, r2_sum); return max;
	 * }
	 */

	private static void printArr(int[] s1) {
		for (int ele : s1)
			System.out.print(ele + " ");
		System.out.println();

	}

	public static int binarySearch(int[] arr, int low, int high, int toSearch) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		if ((mid == 0 || arr[mid - 1] < toSearch) && arr[mid] == toSearch)
			return mid;
		if (arr[mid] > toSearch)
			return binarySearch(arr, low, mid - 1, toSearch);
		return binarySearch(arr, mid + 1, high, toSearch);
	}

	public static int getSum(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
