package lintcode.dp;

public class CoinsInALineIII {
	public boolean firstWillWin(int[] values) {
        //dp[i][j] = max(V[i]-dp[i+1][j], V[j]-dp[i][j-1])
		if(values.length==0) return false;
		if(values.length==1) return true;
		int n = values.length;
		int [][] dp = new int [n][n];
		
		for(int l=1;l<n;l++){
			for(int i=0;i<n-l;i++){
			    int j = i+l;
				dp[i][j] = Math.max(values[i]-dp[i+1][j], values[j]-dp[i][j-1]);
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
		
		return dp[0][n-1]>=0;
    }
}
