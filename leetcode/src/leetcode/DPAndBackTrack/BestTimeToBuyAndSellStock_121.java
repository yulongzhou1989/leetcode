package leetcode.DPAndBackTrack;

public class BestTimeToBuyAndSellStock_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
	
        int currentMax = 0, result = 0;
        for (int i=0;i<prices.length;i++){
            currentMax = Math.max(0, currentMax+=prices[i]-prices[i-1]);
            result = Math.max(currentMax, result);
        }
        
        return result;
    }
}
