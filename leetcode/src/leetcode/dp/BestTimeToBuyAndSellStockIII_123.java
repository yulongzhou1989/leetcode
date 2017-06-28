package leetcode.dp;

public class BestTimeToBuyAndSellStockIII_123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//On time, On space
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
		int n = prices.length;
		int [][] dp = new int [n+1][4];//4 status, first buy, first sell, second buy, second sell, i before that day
		//case1: status 0/2-> buy dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]-P[i-1]) keep buy/buy previous day
		//case2: status 1/3-> no stock these days. dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]+P[i-1]) hold/sell
		dp[0][0] = dp[0][2] = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			for(int j=0;j<4;j++){
				//case 1:
				if(j%2==0){
					dp[i][j] = Math.max(dp[i-1][j], (j>0?dp[i-1][j-1]:0) - prices[i-1]);
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + prices[i-1]);
				}
			}
		}
		return Math.max(dp[n][1], dp[n][3]);
    }
	
	//On time, O1 space
	public int maxProfit1(int[] prices) {
        if(prices==null || prices.length==0) return 0;
		int n = prices.length;
		int [][] dp = new int [2][4];//4 status, first buy, first sell, second buy, second sell, i before that day
		//case1: status 0/2-> buy dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]-P[i-1]) keep buy/buy previous day
		//case2: status 1/3-> no stock these days. dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]+P[i-1]) hold/sell
		dp[0][0] = dp[0][2] = Integer.MIN_VALUE;
		
		int cur = 1, pre = 0;
		for(int i=1;i<=n;i++){
			for(int j=0;j<4;j++){
				//case 1:
				if(j%2==0){
					dp[cur][j] = Math.max(dp[pre][j], (j>0?dp[pre][j-1]:0) - prices[i-1]);
				}
				else{
					dp[cur][j] = Math.max(dp[pre][j], dp[pre][j-1] + prices[i-1]);
				}
				//System.out.println("dp[cur][j]:" + dp[cur][j] + ",cur:" + cur);
			}
			//System.out.println("------");
			pre = cur;
			cur = 1-pre;//swap
		}
		
		return Math.max(dp[pre][1], dp[pre][3]);
    }
}
