package com.geeksforgeeks.array;

/*
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
import java.util.ArrayList;
import java.util.List;

class Stock {
	int buy;
	int sell;
}

public class SellStocksAnyDay {

	public static void main(String[] args) {
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;
		getMaxProfit(price, n);
	}

	public static void getMaxProfit(int[] arr, int n) {
		List<Stock> list = new ArrayList<>();
		int i = 0, count = 0;

		while (i < n - 1) {
			// Get local minima
			while (i < n - 1 && arr[i + 1] <= arr[i])
				i++;
			if (i == n - 1)
				break;
			Stock stock = new Stock();
			stock.buy = i++;

			// Get local maxima
			while (i < n && arr[i] >= arr[i - 1])
				i++;
			stock.sell = i - 1;
			list.add(stock);
			count++;

		}
		if (count == 0)
			System.out.println("No day to earn profit");

		for (i = 0; i < count; i++) {
			System.out.println("Bought on day " + list.get(i).buy
					+ " and sold on : " + list.get(i).sell);
		}

	}

}
