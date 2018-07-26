package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/find-two-rectangles-overlap/
 */
class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class RectanglesOverlap {

	public static void main(String[] args) {
		Point l1 = new Point(0, 10), r1 = new Point(10, 0);
		Point l2 = new Point(5, 5), r2 = new Point(15, 0);
		
		System.out.println("Rectangles overlap : " + isOverlap(l1, r1, l2, r2));
	}
	
	public static boolean isOverlap(Point l1, Point r1, Point l2, Point r2){
		if((r1.x < l2.x || l1.x > r1.x) || (r1.y > l2.y || l1.y < r2.y))
			return false;
		return true;
	}

}
