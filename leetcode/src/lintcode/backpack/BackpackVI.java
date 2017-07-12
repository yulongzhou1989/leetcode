package lintcode.backpack;

public class BackpackVI {
	public int backPackVI(int[] nums, int target) {
        // dp[i] = sum(dp[i-A[0]]....dp[i-A[n-1]])
		if(target == 0 || nums.length==0) return 0;
		int n = nums.length;
		int [] dp = new int [target+1];
		dp[0] = 1;
		for(int i=1; i<=target;i++){
			for(int j=0;j<n;j++){
				dp[i] += (i>=nums[j]?dp[i-nums[j]]:0);
			}
		}
		
		return dp[target];
		
	}
}
