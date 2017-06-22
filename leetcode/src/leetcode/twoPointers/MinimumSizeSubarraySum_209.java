package leetcode.twoPointers;

public class MinimumSizeSubarraySum_209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
		//2 pointers records left and right boundary
		int len = Integer.MAX_VALUE;
		int sum = 0;
		for(int i=0, j=0; i<nums.length;i++){
			while(j<nums.length && sum<s){
				sum += nums[j++];
			}
			if(sum>=s){
				len = Math.min(len, j-i);
			}
			sum -= nums[i];
		}
		
		return len==Integer.MAX_VALUE?0:len;
    }

}
