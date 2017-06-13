package leetcode.StringArray;

import java.util.Arrays;

public class LongestHarmoniousSubsequence_594 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findLHS(int[] nums) {
		if(nums.length<1) return nums.length;		
        Arrays.sort(nums);
		int curLen = 0, preLen = 0, preNum = nums[0], max=0;
		
		for(int i=0;i<nums.length;){
		    int curNum=nums[i];
			while(i<nums.length && curNum == nums[i]){
			  i++;
			  curLen++;
			} 
			if(curNum-preNum==1){
				max = Math.max(preLen+curLen, max);
			} 
			preLen = curLen;
		    preNum = curNum;
		    curLen = 0;
		}
		
		return max;
    }

}
