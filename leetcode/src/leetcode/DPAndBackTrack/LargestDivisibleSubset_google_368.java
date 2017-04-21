package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_google_368 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		Arrays.sort(nums);
		int [] dp = new int [nums.length]; 
		dp[0] = 1;
		
		//for each element in nums, find the length of largest subset it has
		for(int i=1; i<nums.length;i++){
			for(int j=i-1; j>=0;j--){
				if(nums[i]%nums[j] == 0){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		//get the index of largest maxLength
		int maxIndex = 0;
		for(int i=1; i<nums.length; i++){
			maxIndex = dp[i]>dp[maxIndex]?i:maxIndex;
		}
		
		//add all element belongs to that largest number
		int largest = nums[maxIndex];
		int dpDgr = dp[maxIndex];
		for(int i=maxIndex;i>=0;i--){
			if(largest%nums[i] == 0 && dpDgr == dp[i]){
				res.add(0, nums[i]);
				largest = nums[i];
				dpDgr--;
			}
		}
		return res;
    }
}
