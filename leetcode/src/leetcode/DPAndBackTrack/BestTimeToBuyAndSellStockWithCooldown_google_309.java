package leetcode.DPAndBackTrack;

public class BestTimeToBuyAndSellStockWithCooldown_google_309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxProfit(int[] prices) {
        int buy=Integer.MIN_VALUE, sell=0, preSell=0, preBuy=0;
		
		for(int i=0;i<prices.length;i++){
			//buy[i] = max(sell[i-2]-price, buy[i-1])
			//sell[i] = max(buy[i-1]+price, sell[i-1])
			preBuy = buy;
			buy = Math.max(preSell-prices[i], preBuy);
			preSell = sell;
			sell = Math.max(preBuy+prices[i], preSell);
		}
		
		return sell;
    }
}
