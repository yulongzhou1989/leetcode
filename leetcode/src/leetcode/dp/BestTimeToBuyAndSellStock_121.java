package leetcode.dp;

public class BestTimeToBuyAndSellStock_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int p: prices){
        	minPrice = Math.min(p, minPrice);
        	max = Math.max(p-minPrice, max);
        }
        
        return max;
    }

}
