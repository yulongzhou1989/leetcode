package leetcode.StringArray;

import java.util.HashSet;

public class SplitArrayWithEqualSum_548 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean splitArray(int[] nums) {
        if(nums.length<7) return false;
		int [] sum = new int [nums.length];
		sum[0] = nums[0];
		for(int i=1;i<nums.length;i++){
			sum[i] = sum[i-1]+nums[i];
		}
		//use j seperate to 2 parts, and i, k seperate these two parts to 4 parts
		for(int j=3;j<nums.length-3;j++){
			HashSet<Integer> set = new HashSet<>();
			for(int i=1;i<j-1;i++){
				if(sum[i-1] == sum[j-1]-sum[i]) set.add(sum[i-1]); 
			}
			for(int k=j+1;k<nums.length-1;k++){
				if(sum[k-1]-sum[j] == sum[nums.length-1]-sum[k] && set.contains(sum[k-1]-sum[j])) return true;
			}
		}
		
		return false;
    }
}
