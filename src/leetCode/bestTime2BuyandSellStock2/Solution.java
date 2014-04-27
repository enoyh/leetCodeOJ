package leetCode.bestTime2BuyandSellStock2;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int sum = 0;
		int minIndex,maxIndex;
		minIndex = maxIndex = 0;
		for(int i = 0;i < len-1;i++){
			if(prices[i+1] >= prices[i])
				maxIndex = i+1;
			else{
				sum += prices[maxIndex] - prices[minIndex];
				minIndex = maxIndex = i+1;
			}
				
		}
		sum += prices[maxIndex] - prices[minIndex];
		return sum;

	}
}
