package com.geeksforgeeks.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		//int noOfDisks = 2;
		int noOfDisks = 4;
		towerOfHanoi(noOfDisks,"A","B","C");
	}
	
	public static void towerOfHanoi(int disks,String fromRod,String auxRod,String toRod){
		if(disks==1){
			System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
			return;
		}
		towerOfHanoi(disks-1,fromRod,toRod,auxRod);
		System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
		towerOfHanoi(disks-1,auxRod,fromRod,toRod);
	}
}