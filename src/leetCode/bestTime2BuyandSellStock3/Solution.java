package leetCode.bestTime2BuyandSellStock3;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {1,2,4,2,5,7,2,4,9,0};
		
		System.out.println(new Solution().maxProfit(prices));

	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int historyProfit[] = new int[len];
		int futureProfit[] = new int[len];
		int maxProfit = 0;
		int minPrice = prices[0],maxPrice= prices[len-1];
		historyProfit[0] = 0;
		futureProfit[len-1] = 0;
		
		for(int i = 0;i < len;i++){
			minPrice = Math.min(minPrice, prices[i]);
			if(i >0){
				historyProfit[i] = Math.max(prices[i] - minPrice,historyProfit[i-1]);
			}
		}
		for(int i = len-1;i >= 0;i--){
			maxPrice = Math.max(maxPrice, prices[i]);
			if(i < len-1){
				futureProfit[i] = Math.max(maxPrice - prices[i],futureProfit[i+1]);
			}
			maxProfit = Math.max(futureProfit[i] + historyProfit[i],maxProfit);
		}
		
		return maxProfit;
	}
}
