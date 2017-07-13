package lintcode.dp;

public class BurstBallons {
	public int maxCoins(int[] nums) {
        //dp[i][j] = dp[i][k]+ dp[i]* dp[k]* dp[j] + dp[k][j]
		if(nums.length==0) return 0;
		int n = nums.length;
		n += 2;
		int [] inums = new int [n];
		inums[0] = 1;
		inums[n-1] = 1;
		for(int i=1;i<n-1;i++){
			inums[i] = nums[i-1];
		}
		int [][] dp = new int [n][n];
		for(int l=2;l<n;l++){
			for(int i=0;i<n-l;i++){
				int j = i+l;
				for(int k=i+1;k<j;k++){
					dp[i][j] = Math.max(dp[i][j], dp[i][k] + inums[i]*inums[k]*inums[j] + dp[k][j]);
				}
			}
		}
		//System.out.println(Arrays.deepToString(dp));
		return dp[0][n-1];
    }
}
