package lintcode.dp;

public class CopyBooks {
	public int copyBooks(int[] pages, int k) {
        if(k==0 || pages.length==0) return 0;
		int n = pages.length;
		//dp[i][j] = min(k->0...j max(dp[i][j-k], sum(k->j))) i -> 前i 个人， j->前j本书
		int [][] dp = new int [k+1][n+1];
		
		for(int i=1;i<=n;i++){
		    dp[0][i] = Integer.MAX_VALUE;
		}
		
		for(int i=1;i<=k;i++){
			for(int j=0;j<=n;j++){
				int sum = 0;
				dp[i][j] = Integer.MAX_VALUE;
				for(int m=j;m>=0;m--){
					dp[i][j] = Math.min(Math.max(dp[i-1][m], sum), dp[i][j]);
				    if(m>0) sum += pages[m-1];
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
		
		return dp[k][n];
    }
}
