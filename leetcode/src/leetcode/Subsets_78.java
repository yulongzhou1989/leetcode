package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3};
		System.out.println(subsets(nums));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		Arrays.sort(nums);
        backwardSubsets(result, new ArrayList<Integer> (), 0, nums);
        return result;
    }
	
	public static void backwardSubsets(List<List<Integer>> result, List<Integer> tempList, int start, int [] nums){
		result.add(new ArrayList<Integer>(tempList));
		
		for (int i=start;i<nums.length;i++){
			tempList.add(nums[i]);
			backwardSubsets(result, tempList, i+1, nums);
			tempList.remove(tempList.size()-1);
		}
	}
}
