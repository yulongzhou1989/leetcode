package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex_google_398 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
	    
	//	    //key: val, value: indexes of val
	//	    Map<Integer, List<Integer>> map;
	//
	//	    public Solution(int[] nums) {
	//	        map = new HashMap<Integer, List<Integer>>();
	//	        for(int i=0;i<nums.length;i++){
	//	            if(!map.containsKey(nums[i])){
	//	                List<Integer> list = new ArrayList<Integer>();
	//	                list.add(i);
	//	                map.put(nums[i],list);
	//	            }else{
	//	                map.get(nums[i]).add(i);
	//	            }
	//	        }
	//	    }
	//	    
	//	    public int pick(int target) {
	//	        Random rand = new Random();
	//	        int index = rand.nextInt(map.get(target).size());
	//	        return map.get(target).get(index);
	//	    }
	    
	    int[] nums;
	    Random rand;
	    public Solution(int[] nums) {
	        this.nums = nums;
	        this.rand = new Random();
	    }
	    public int pick(int target) {
	        int total = 0;
	        int res = -1;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == target) {
	                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. 
	            	// The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
	                int x = rand.nextInt(++total); 
	                res = x == 0 ? i : res;
	            }
	        }
	        return res;
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int param_1 = obj.pick(target);
	 */
}
