package leetcode.sort;

import java.util.Arrays;

public class ShortestUnsortedContinousSubarray_google_1_581 {

	//On On space
	public int findUnsortedSubarray(int[] nums) {
        int [] temp = nums.clone();
		Arrays.sort(nums);
		int i=0,j=nums.length-1;
		while(i<nums.length){
			if(nums[i]!=temp[i]) break;
			i++;
		}
		while(j>=i){
			if(nums[j]!=temp[j]) break;
			j--;
		}
		
		return j-i+ (nums[i]==nums[j]?0:1);
    }
	
	//On o1 space
	public int findUnsortedSubarray1(int[] nums) {
        int n= nums.length, start = -1, end =-2, min = nums[n-1], max = nums[0];
		for(int i=0;i<nums.length;i++){
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[n-i-1]);
			if(nums[i]<max) end = i;
			if(nums[n-i-1]>min) start = n-i-1;
		}
		
		return end-start+1;
    }
}
