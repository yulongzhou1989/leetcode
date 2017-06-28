package leetcode.dp;

public class BestTimeToSellStockVI_188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int k, int[] prices) {
        if(k==0 || prices==null || prices.length==0) return 0;
		int n = prices.length;
		
		//case1: status 0/2-> buy dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]-P[i-1]) keep buy/buy previous day
		//case2: status 1/3-> no stock these days. dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]+P[i-1]) hold/sell
		System.out.println(n);
		if(k>=n/2){//same as unlimit time
		    int res = 0;
		    for(int i=1;i<n;i++){
		        res += (prices[i]-prices[i-1]>0)?(prices[i]-prices[i-1]):0; 
		    }
		    
		    return res;
		}
		
		int [][] dp = new int [2][2*k+1];//4 status, first buy, first sell, second buy, second sell, i before that day
		int cur = 1, pre = 0;
		for(int i=0;i<=k;i++){
		    dp[0][i*2] = Integer.MIN_VALUE;
		}
		for(int i=1;i<=n;i++){
			for(int j=0;j<2*k+1;j++){
				//case 1:
				if(j%2==0){
					dp[cur][j] = Math.max(dp[pre][j], (j>0?dp[pre][j-1]:0) - prices[i-1]);
				}
				else{
					dp[cur][j] = Math.max(dp[pre][j], dp[pre][j-1] + prices[i-1]);
				}
			}
			pre = cur;
			cur = 1-pre;//swap
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=2*k;i>=k;i--){
		    if(i%2==1)
		        max = Math.max(dp[pre][i], max);
		}
		
		return max;
    }

}
