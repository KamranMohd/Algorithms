package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/print-given-matrix-zigzag-form/
 */
public class PrintZigZagMatrix {

	public static void main(String[] args) {
		int mat[][] = { {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
            };
		printZigZag(mat, mat.length, mat[0].length);
	}
	
	public static void printZigZag(int [][] mat, int rows, int cols){
		int r1 = 0, r2 = rows-1, c1 = 0, c2 = cols-1;
		while(r1<=r2){
			for(int k=c1;k<=c2;k++)
				System.out.print(mat[r1][k] + " ");
			r1++;
			if(r1<=r2){
				for(int k=c2;k>=0;k--)
					System.out.print(mat[r1][k] + " ");
			}
			r1++;
		}
	}
}