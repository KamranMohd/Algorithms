package com.geeksforgeeks.array;

/**
 * https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
 * @author kamran
 *
 */
public class PrintDiagonalMatrix {

	public static void main(String[] args) {
		/*int M[][] = {
		        {1, 2, 3, 4},     {5, 6, 7, 8},     {9, 10, 11, 12},
		        {13, 14, 15, 16}, {17, 18, 19, 20},
		    };*/
		int M[][] = {
		        {1, 2, 3, 4},     {5, 6, 7, 8},     {9, 10, 11, 12}
		    };
		printDiagonal(M, M.length, M[0].length);
	}
	
	public static void printDiagonal(int [][] mat, int rows, int cols){
		int startRow = 0;
		while(startRow<rows){
			for(int i=startRow, j=0;i>=0 && j<cols; i--,j++){
				System.out.print(mat[i][j] + " ");
			}
			startRow++;
			System.out.println();
		}
		int startCol = 1;
		while(startCol<cols){
			for(int i=startCol,j=rows-1;i<cols && j>=0;i++,j--){
				System.out.print(mat[j][i] + " ");
			}
			startCol++;
			System.out.println();
		}
	}
}