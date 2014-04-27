package leetCode.bestTime2BuyandSellStock;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if(len <= 1)
			return 0;
		int minPrice = prices[0];
		int maxProfit = 0;
		for(int i = 1;i < len;i++){
			minPrice = Math.min(minPrice, prices[i]);
			if(maxProfit < prices[i]-minPrice)
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}

}
