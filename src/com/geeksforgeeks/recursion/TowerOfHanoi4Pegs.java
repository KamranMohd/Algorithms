package com.geeksforgeeks.recursion;

public class TowerOfHanoi4Pegs {

	public static void main(String[] args) {
		moveDisks(4, "A", "D", "B", "C");
	}
	
	public static void moveDisks(int disk,String from_rod, String to_rod, String aux_rod1, String aux_rod2){
		if(disk==0)
			return;
		if(disk==1){
			System.out.println("Move disk " + disk + " from rod " + from_rod +  " to rod " + to_rod);
			return;
		}
		moveDisks(disk-2,from_rod,aux_rod1,aux_rod2,to_rod);
		System.out.println("Move disk " + (disk-1) + " from rod " + from_rod + " to rod " + aux_rod2);
		System.out.println("Move disk " + (disk) + " from rod " + from_rod + " to rod " + to_rod);
		System.out.println("Move disk " + (disk-1) + " from rod " + aux_rod2 + " to rod " + to_rod);
		moveDisks(disk-2,aux_rod1,to_rod,from_rod,aux_rod2);
	}
}