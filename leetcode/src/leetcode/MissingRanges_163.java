package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String> ();
        if (upper<nums[0] || lower>nums[nums.length-1]) {
    		String range = generateResultString(lower, upper);
    		if (range!="")
    			result.add(range);
    	}
        
        for (int i=0;i<nums.length;i++){
        	
        	
        }
    }
	
	public static String generateResultString(int a, int b){
		if (b-a == 2){
			return (a+1)+"";
		} else if (b-a < 2){
			return "";
		} else {
			return (a+1)+"->"+(b-1);
		}
	}
	
/*	Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
 *  return its missing ranges.
	For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].*/

}
