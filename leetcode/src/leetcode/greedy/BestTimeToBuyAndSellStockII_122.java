package leetcode.greedy;

public class BestTimeToBuyAndSellStockII_122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
        int res = 0;
        for(int i=1;i<prices.length;i++){
            res += prices[i]-prices[i-1]>0?(prices[i]-prices[i-1]):0;
        }
        return res;
    }
}
