package leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequenence_300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	* increase sequence
	* len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
	* len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
	* len = 3   :      [4, 5, 6]            => tails[2] = 6
	*
	* (1) if x is larger than all tails, append it, increase the size by 1
	* (2) if tails[i-1] < x <= tails[i], update tails[i]
	*/

	//Onlogn binary search + dp
    public int lengthOfLIS(int[] nums) {
        int [] tails = new int [nums.length];
		int size = 0;
		//insert the number
		for(int x:nums){
			int i=0, j=size;
			while(i!=j){
				int m = (i+j)/2;
				if(tails[m]<x) {
					i = m+1;
				}else{
					j = m;
				}
			}
			tails[i] = x;
			//if append, size+1
			if(i==size) size++;
		}
		
		return size;
    }
	
	//On*n
	public int lengthOfLIS1(int[] nums) {
		if(nums==null) return 0;
		if(nums.length<2) return nums.length;
		//keep the longest sub end with i
        int [] dp = new int [nums.length];
		int res = Integer.MIN_VALUE;
		
		Arrays.fill(dp, 1);
		
		for(int i=1;i<nums.length;i++){
			for(int j=0; j<i;j++){
				//j has contribute to i
				if(nums[j]<nums[i]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		
		return res;
    }
}
