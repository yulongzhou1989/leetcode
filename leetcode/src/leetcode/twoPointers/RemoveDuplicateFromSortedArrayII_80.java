package leetcode.twoPointers;

public class RemoveDuplicateFromSortedArrayII_80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
		
		int j = 0;
		for(int i=0;i<nums.length;i++){// insert the arr when 2 same number has aleady inserted.
			if(j<2 || nums[i]>nums[j-2]){
				nums[j++] = nums[i];
			}
		}
		
		return j;
    }

}
