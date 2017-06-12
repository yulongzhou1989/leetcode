package leetcode.twoPointers;

import java.util.Arrays;

public class ValidTriangleNumber_611 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
		int count = 0;
		for(int k=nums.length-1;k>=2;k--){
			int i=0, j=k-1;
			while(i<j){
				if(nums[i]+nums[j]<=nums[k])i++;
				if(i==j) break;
				count += j-i;
				j--;
			}
		}
		
		return count;
    }
	
	public int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
		int count = 0;
		for(int k=nums.length-1;k>=2;k--){
			int i=0, j=k-1;
			while(i<j){
				if(nums[i]+nums[j]<=nums[k])i++;
				if(i==j) break;
				count += j-i;
				j--;
			}
		}
		
		return count;
    }
}
