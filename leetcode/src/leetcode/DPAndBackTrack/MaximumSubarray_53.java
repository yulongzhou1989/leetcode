package leetcode.DPAndBackTrack;

public class MaximumSubarray_53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
//	 public int helper (int [] nums, int max, int pos, int cur){
//	        if (pos == nums.length-1) return max;
//	        for (int i=pos; i<nums.length; i++){
//	            
//	        }
//	    }
	
	//O(n*n) time
	public static int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j=i;j<nums.length;j++){
                sum += nums[j];
                max = Math.max(sum,max);
            }
        }  
        
        return max;
    }
	
	//O(n) DP way
	//maxSubArray(A, i) = maxSubArray(A, i-1)? maxSubArray(A, i-1)?0:+A[i];
	public static int maxSubArray(int [] nums){
		
		int dp[] = new int [nums.length];
		dp[0] = nums[0];
		int max =  dp[0];
		for (int i=1; i<nums.length;i++){
			dp[i] = (dp[i-1]>0?dp[i-1]:0) + nums[i];
			max = Math.max(dp[i], max);
		}
		
		return max;
		
	}
	
}
