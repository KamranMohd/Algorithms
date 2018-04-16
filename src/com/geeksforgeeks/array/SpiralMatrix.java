package com.geeksforgeeks.array;

/**
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * @author kamran
 * Note: To print the matrix in anti-spiral form, store the spiral matrix in stack 
 * and print it. It will be in reverse spiral form.
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int a[][] = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		    /*int a[][] = { {1,  2,  3,  4,  5,  6}
			    };*/
		printSpiralMatrix(a, a.length, a[0].length);
	}
	
	public static void printSpiralMatrix(int mat[][], int rows, int cols){
		int lc = 0, rc = cols-1, tr = 0, br = rows-1;
		int tempLc = lc, tempRc = rc, tempTr = tr, tempBr = br;
		while(lc <= rc && tr <= br){
			while(tempLc <= tempRc)
				System.out.print(mat[tempTr][tempLc++] + " ");
			tempTr++;
			while(tempTr<=tempBr && tr<br)
				System.out.print(mat[tempTr++][tempRc] + " ");
			tempRc--;
			while(tempRc>lc && tr<br)
				System.out.print(mat[tempBr][tempRc--] + " ");
			tempBr--;
			while(tempBr > tr)
				System.out.print(mat[tempBr--][lc] + " ");
			lc++;rc--;tr++;br--;
			tempLc = lc; tempRc = rc; tempTr = tr; tempBr = br;
		}
	}

}
