package leetcode.dp;

public class EditDistance_72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
		int l1 = word1.length();
		int l2 = word2.length();
		if(l1==0 || l2==0) return l1==0?l2:l1;
		int [][] dp = new int [l1+1][l2+1];//dp[i][j] --> w1 0->i-1, w2 0->j-1
		//initial dp
		for(int i=0;i<=l1;i++){
			dp[i][0] = i;
		}
		for(int j=0;j<=l2;j++){
			dp[0][j] = j;
		}
		
		for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = (Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])))+1;
				}
			}
		}
		
		return dp[l1][l2];
    }
}
