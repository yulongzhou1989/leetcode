package leetcode;

import java.util.Arrays;

public class Google_3SumSmaller_259 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int threeSumSmaller(int [] nums, int target){
		int result = 0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3; i++){
			int lo = i+1;
			int hi = nums.length-1;
			
			while(lo<hi){
				if (nums[i]+nums[lo]+nums[hi]<target){
					result+=hi-lo;
					lo++;
				}else {
					hi--;
				}
			}
		}
		
		return result;
	}
}
