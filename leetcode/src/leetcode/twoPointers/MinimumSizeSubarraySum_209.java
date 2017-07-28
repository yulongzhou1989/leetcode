package leetcode.twoPointers;

public class MinimumSizeSubarraySum_209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
		int sum = 0, min = Integer.MAX_VALUE;
		for(int i=0,j=0;i<n;i++){
			while(j<n && sum<s){
				sum+=nums[j];
				j++;
			}
			//System.out.println(sum + "," +i + "," + j);
			if(sum>=s){
				min = Math.min(min, j-i);
			}
			sum-=nums[i];
		}
		
		return min==Integer.MAX_VALUE?0:min;
    }

}
