package leetcode.dp;

public class InterleavingString_97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		
        if(s1==null || s2==null || s1.length() + s2.length()!=s3.length()) return false;
		int n1 = s1.length();
		int n2 = s2.length();
		
		boolean [][] dp = new boolean [n1+1][n2+1];//dp[i][j] s1 end with i, s2 end with j

		dp[0][0] = true;
		for(int i=1;i<=n1;i++){
			dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
		}
		for(int j=1;j<=n2;j++){
			dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
		}
		
		
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
				dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) 
						|| (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
			}
		}
		
		return dp[n1][n2];
    }
}
