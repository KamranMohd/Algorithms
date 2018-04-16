package com.geeksforgeeks.searching;

public class FloorAndCeil {

	public static void main(String[] args) {
		int arr [] = {1, 2, 8, 10, 10, 12, 19};
		int x = 20;
		printFloorCeil(arr,x);
	}

	public static void printFloorCeil(int [] arr, int x){
		boolean ceil = false;
		int floor = -99999;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>=x && ceil==false){
				System.out.println("ceil = " + arr[i]);
				ceil = true;
			}
			if(arr[i]<=x)
				floor = arr[i];
		}
		if(floor!=-99999){
			System.out.println("Floor = " + floor);
		}else
			System.out.println("Floor doesn't exist");
		if(ceil==false)
			System.out.println("ceil does not exist");
	}
}
