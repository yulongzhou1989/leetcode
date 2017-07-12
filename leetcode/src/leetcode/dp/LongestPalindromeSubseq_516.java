package leetcode.dp;

public class LongestPalindromeSubseq_516 {
	 public int longestPalindromeSubseq(String s) {
	        if(s.length()==0) return 0;
	        //dp[i][j] = dp[i+1][j-1]+2 | s[i] == s[j]
	        //         = max(dp[i][j-1],dp[i+1][j]) | s[i]!=s[j]
	        int n = s.length();
	        int [][]dp = new int [n][n];
	        //initial
	        for(int i=0;i<n;i++){
	            dp[i][i] = 1;
	        }
	        
	        for(int l=2;l<=n;l++){
	            for(int i=0; i<=n-l;i++){
	                int j = i+l-1;
	                if(s.charAt(i) == s.charAt(j)){
	                    dp[i][j] = dp[i+1][j-1] + 2;
	                }else{
	                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
	                }
	            }
	        }
	        
	        return dp[0][n-1];
	    }
}
