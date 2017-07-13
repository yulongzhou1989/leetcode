package leetcode.dp;

public class DeleteOperationForTwoStrings_583 {
	public int minDistance(String word1, String word2) {
        if(word1.length()==0) return word2.length();
		if(word2.length()==0) return word1.length();
		
		int n1 = word1.length();
		int n2 = word2.length();
		//find the longest common substring
		int [][] dp = new int [n1+1][n2+1];
		//dp[i][j] = max(dp[i-1][j], dp[i][j-1]) | w1[j]!=w2[j]
		//         = dp[i-1][j-1] | w1[j] == w2[j]
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return n1+n2-2*dp[n1][n2];
    }
}
