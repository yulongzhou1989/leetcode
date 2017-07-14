package lintcode.dp;

public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
        //dp[i][j] = dp[i-1][j-1]| S[i-1][j-1] + dp[i-1][j]
		if(S.length()==0 && T.length()>0) return 0;
		if(S.length()==0 && T.length()==0) return 1;
		if(T.length()==0) return 1;
		int m = S.length();
		int n = T.length();
		int [][] dp = new int [m+1][n+1];
		for(int i=0;i<=m;i++){
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j] = (S.charAt(i-1) == T.charAt(j-1)?dp[i-1][j-1]:0) + dp[i-1][j];
			}
		}
		
		return dp[m][n];
    }
}
