package lintcode.backpack;

public class Backpack {
	public int backPack(int m, int[] A) {
        // write your code here
        //dp[i][w] = dp[i-1][w] || dp[i-1][w-A[i]]
		if(m==0 || A.length==0) return 0;
		int n = A.length;
		boolean [][] dp = new boolean [n+1][m+1];
		dp[0][0] = true;
		
		for(int i=1;i<=n;i++){
			for(int j=0;j<=m;j++){
				dp[i][j] = dp[i-1][j] || ((j-A[i-1]>=0)?dp[i-1][j-A[i-1]]:false);
			}
		}
		//System.out.println(Arrays.deepToString(dp));
		for(int i=m;i>=0;i--){
		    //System.out.println(dp[i][m]);  
			if(dp[n][i]) return i;
		}
		
		return 0;
    }
}
