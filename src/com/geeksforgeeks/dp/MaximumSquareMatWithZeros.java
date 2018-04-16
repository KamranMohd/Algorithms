package com.geeksforgeeks.dp;

/**
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * @author kamran
 *
 */

public class MaximumSquareMatWithZeros {

	public static void main(String[] args) {
		int M[][] =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		printMaxSquare0Mat(M);
	}
	
	public static void printMaxSquare0Mat(int [][] mat){
		int rows = mat.length;
		int columns = mat[0].length;
		int aux[][] = new int[rows][columns];
		
		//	Writing the first row in auxiliary matrix
		for(int i=0;i<columns;i++)
			aux[0][i] = mat[0][i];
		
		//	Writing the first column in the auxiliary matrix
		for(int i=0;i<rows;i++)
			aux[i][0] = mat[i][0];
		
		//	Filling the rest of the auxiliary matrix
		for(int i=1;i<rows;i++){
			for(int j=1;j<columns;j++){
				if(mat[i][j]==1)
					aux[i][j] = getMin(aux[i-1][j], aux[i-1][j-1], aux[i][j-1]) + 1;
				else
					aux[i][j] = 0;
			}
		}
		
		//	Finding the maximum element in aux matrix
		int maxElement = aux[0][0], max_i=-1, max_j=-1;
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(aux[i][j] > maxElement){
					maxElement = aux[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		
		//	Printing the sub matrix
		for(int i=max_i;i>max_i-maxElement;i--){
			for(int j=max_j;j>max_j-maxElement;j--)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
	
	public static int getMin(int a, int b, int c){
		return Math.min(Math.min(a, b), c);
	}
}