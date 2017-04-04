package leetcode.StringArray;

import java.util.Random;

public class ShuffleAnArray_384 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
	    
	    int [] nums;
	    Random rand;

	    public Solution(int[] nums) {
	        this.nums = nums;
	        rand = new Random();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        if(nums==null) return null;
	        int [] a = nums.clone();
	        for(int i=1;i<a.length;i++){
	            swap(a, i, rand.nextInt(i+1));
	        }
	        return a;
	    }
	    
	    private void swap(int [] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	}
}
