package leetcode.dp;

public class PartitionEqualSubsetSum_416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canPartition(int[] nums) {
        if(nums==null || nums.length==0) return false;
		
		int sum = 0;
		for(int num:nums){
			sum+=num;
		}
		
		if((sum&1)>0) return false;// can not been cut to two parts
		sum = sum>>1;
		boolean [] dp = new boolean [sum+1];
		dp[0] = true;
		for(int i=0;i<nums.length;i++){
			for(int j = sum; j>=nums[i]; j--){
				dp[j] = dp[j] || dp[j-nums[i]]; 
			}
		}
		
		return dp[sum];
    }

}
