package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums));
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        Arrays.sort(nums);
        backwardSubsetsWithDup(result, new ArrayList<Integer> (), nums, 0);
        return result;
    }
	
	public static void backwardSubsetsWithDup(List<List<Integer>> l, List<Integer> tempList
			, int [] nums, int start){
		l.add(new ArrayList<Integer>(tempList));
		for (int i=start; i<nums.length;i++){
			if (start<i && nums[i-1] == nums[i]) continue;
			tempList.add(nums[i]);
			backwardSubsetsWithDup(l, tempList, nums, i +1);
			tempList.remove(tempList.size()-1);
		}
	}

}
