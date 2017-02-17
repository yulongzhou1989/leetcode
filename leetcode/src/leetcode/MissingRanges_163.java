package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {-2147483648,-2147483647,0,2147483647,2147483647};
		System.out.println(findMissingRanges1(nums, -2147483648, 2147483647));
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String> ();
        
        int pre = lower - 1;
        for (int i=0;i<=nums.length;i++){
        	int after = i== nums.length?upper + 1:nums[i];
        	if (pre +2 == after){
        		result.add(String.valueOf(pre+1));
        	}else if(pre+2 <after){
        		result.add(String.valueOf(pre+1) + "->" + String.valueOf(after-1));
        	} 
        	pre = after;
        }
        
        return result;
    }
	
	public static List<String> findMissingRanges1(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String> ();
		
		for (int i=0;i<nums.length;i++){
			if (nums[i] == Integer.MIN_VALUE){
				lower = nums[i]+1;
				continue;
			}
			if (lower == nums[i]) {
				lower = nums[i]+1;
			}else if (lower == nums[i]-1){
				result.add(lower+"");
			}else if (lower < nums[i]-1){
				result.add(lower+"->"+(nums[i]-1));
			} 
			if (nums[i] == Integer.MAX_VALUE) return result;
			lower = nums[i] + 1;
		}
		
		if (lower == upper) result.add(lower+"");
		else if (lower < upper) result.add(lower + "->" +upper);
		return result;
	}
	
	
/*	Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
 *  return its missing ranges.
	For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].*/

}
