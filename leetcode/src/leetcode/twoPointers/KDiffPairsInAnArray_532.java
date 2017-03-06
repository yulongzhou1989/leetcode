package leetcode.twoPointers;

import java.util.Arrays;

public class KDiffPairsInAnArray_532 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        int count = 0;
        
        for (int i=0;i<nums.length;i++){
        	while(i>0&&i<nums.length&&nums[i-1]==nums[i]) i++;
            int j = i+1;
            while(j<nums.length&&nums[j]<nums[i]+k) j++;
            if (j<nums.length&&nums[j] == nums[i]+k) count ++;
        }
        
        return count;
    }
}
