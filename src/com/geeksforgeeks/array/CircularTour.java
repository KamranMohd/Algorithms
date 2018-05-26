package com.geeksforgeeks.array;

/*
 *	https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/ 
 */

class PetrolPump {
	int dist;
	int petrol;

	public PetrolPump(int petrol, int dist) {
		this.dist = dist;
		this.petrol = petrol;
	}
}

public class CircularTour {

	public static void main(String[] args) {
		// {4, 6}, {6, 5}, {7, 3} and {4, 5}.
		// PetrolPump arr[] = { new PetrolPump(4, 6), new PetrolPump(6, 5),
				//new PetrolPump(7, 3), new PetrolPump(4, 5) };
		PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};
		System.out.println("Starting petrol pump : " + getStart(arr, arr.length));
	}

	public static int getStart(PetrolPump[] arr, int size) {
		int start = 0, end = 1;
		int currentPetrol = arr[start].petrol - arr[start].dist;
		while (start != end || currentPetrol < 0) {
			while (currentPetrol < 0 && start != end) {
				currentPetrol -= (arr[start].petrol - arr[start].dist);
				start = (start + 1)%size;
				if(start==0)
					return 1;
			}
			currentPetrol += (arr[end].petrol - arr[end].dist);
			end = (end+1)%size;
		}
		return start;
	}
}
