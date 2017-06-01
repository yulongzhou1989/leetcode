package leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequenence_300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
