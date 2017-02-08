package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsII_47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,3,3};
		System.out.println(permuteUnique(nums));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        Arrays.sort(nums);
        getPermuteUnique(result, new ArrayList<Integer>(), nums, new boolean [nums.length]);
        return result;
    }
	
	public static void getPermuteUnique (List<List<Integer>> l, List<Integer> tempList, int [] nums, boolean [] used){
		if (tempList.size() == nums.length)
			l.add(new ArrayList<Integer>(tempList));
		
		for (int i=0;i<nums.length;i++){
			if (used[i] || i>0 && nums[i]==nums[i-1] &&!used[i-1]) continue;
			tempList.add(nums[i]);
			used[i] = true;
			getPermuteUnique(l, tempList, nums, used);
			used[i] = false;
			tempList.remove(tempList.size()-1);
		}
	}
}
