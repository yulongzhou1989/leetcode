package leetcode.DPAndBackTrack;

public class PredictWinner_google_486 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {1, 5, 2};
		//System.out.println(PredictTheWinner(nums));
	}

    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer [nums.length+1][nums.length+1])>=0;
    }
	
	private int helper(int [] nums, int start, int end, Integer [][] dp){
		if(dp[start][end]!=null) return dp[start][end];
		dp[start][end] = start==end?nums[start]:Math.max(nums[start]-helper(nums, start+1, end, dp), nums[end]-helper(nums, start, end-1, dp));
        return dp[start][end];
	}
}
