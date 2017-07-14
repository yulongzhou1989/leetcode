package lintcode.dp;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j] = dp[i-1][j] | s3[i+j-2]==s1[i-1] || dp[i][j-1] | s3[i+j-2]==s2[j-1]
		if(s1.length()+s2.length()!=s3.length()) return false;
		int n1 = s1.length();
		int n2 = s2.length();
		boolean [][] dp = new boolean [n1+1][n2+1];
		dp[0][0] = true;
		for(int i=0;i<=n1;i++){
			for(int j=0;j<=n2;j++){
				if(i>0 && s3.charAt(i+j-1) == s1.charAt(i-1)){
					dp[i][j] = dp[i-1][j];
				}
				if(j>0 && s3.charAt(i+j-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i][j] || dp[i][j-1];
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
		
		return dp[n1][n2];
    }
}
