package lintcode.backpack;

public class BackpackV {
	public int backPackV(int[] nums, int target) {
        //dp[i][j] = dp[i-1][j] + dp[i-1][j-num[i]] 
		if(target==0 || nums.length==0) return 0;
		int n = nums.length;
		int [][] dp = new int [n+1][target+1];
		dp[0][0] = 1;
		for(int i=1;i<=n;i++){
			for(int j=0; j<=target;j++){
				dp[i][j] = dp[i-1][j] + (j>=nums[i-1]?dp[i-1][j-nums[i-1]]:0);
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
			
		return dp[n][target];
    }
}
