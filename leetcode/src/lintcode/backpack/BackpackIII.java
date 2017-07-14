package lintcode.backpack;

public class BackpackIII {
	public int backPackIII(int[] A, int[] V, int m) {
        //dp[i][j] = max(dp[i][j-A[i-1]] + V[i-1], dp[i-1][j])
		if(m==0 || A.length==0 || V.length==0) return 0;
		
		int n = A.length;
		
		int [][] dp = new int [n+1][m+1];
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], j>=A[i-1]?(dp[i][j-A[i-1]] + V[i-1]):0));
			}
		}
		
		return dp[n][m];
    }
}
