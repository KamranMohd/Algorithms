package com.geeksforgeeks.recursion;
/**
 * Given coordinates of a source point (x1, y1) determine if it is possible to reach the destination point (x2, y2). 
 * From any point (x, y) there only two types of valid movements:
 * (x, x + y) and (x + y, y). Return a boolean true if it is possible else return false.
 * Note: All coordinates are positive.
 * Link: http://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/ 
 */

public class DestinationReachable {
	public static void main(String[] args) {
		//int x1 = 2,x2 = 26,y1 = 10,y2 = 12; should return true
		int x1 = 20,x2 = 6,y1 = 10,y2 = 12;
		boolean isReachable = isDestReachable(x1,y1,x2,y2,false);
		System.out.println(isReachable);
	}
	public static boolean isDestReachable(int x1,int y1, int x2, int y2,boolean isReachable){
		if(x1>x2 || y1>y2){
			isReachable = false;
			return isReachable;
		}
		if(x1==x2 && y1==y2){
			isReachable = true;
			return isReachable;
		}
		isReachable = isDestReachable(x1+y1, y1, x2, y2,isReachable) || isDestReachable(x1, x1+y1, x2, y2,isReachable);
		return isReachable;
	}
}