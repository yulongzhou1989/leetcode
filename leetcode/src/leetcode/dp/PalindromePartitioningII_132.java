package leetcode.dp;

public class PalindromePartitioningII_132 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minCut(String s) {
		if(s.length()==0) return 0;
		int n = s.length();
		boolean [][] isPalin = new boolean [n][n];
		//initial isPalin
		for(int i=0;i<n;i++){
			isPalin[i][i] = true;
			//odd
			initalIsPalin(isPalin, i-1, i+1, s);
			//even
			initalIsPalin(isPalin, i, i+1, s);
		}
		//dp, dp[i] = dp[j] + 1 | S[j,i-1] isPalin
		int [] dp = new int [n+1];
		for(int i=1;i<=n;i++){
		    dp[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(isPalin[j][i-1])
					dp[i] = Math.min(dp[i], dp[j]+1);
			}
		}
		
		return dp[n]-1;//not how many parts but how many cut
    }
	
	private void initalIsPalin(boolean [][] isPalin, int i, int j, String s){
	    int n = s.length();
		while(i>=0&&j<n && s.charAt(i) == s.charAt(j)){
			isPalin[i][j] = true;
			j++;
			i--;
		}
	}

}
