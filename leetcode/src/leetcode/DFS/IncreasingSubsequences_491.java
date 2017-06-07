package leetcode.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences_491 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
		//dfs
		dfs(res, new ArrayList<>(), nums, 0);
		return new ArrayList(res);
    }
	
	private void dfs(Set<List<Integer>> res, List<Integer> temp, int [] nums, int pos){
	    if(temp.size()>1)
		    res.add(new ArrayList<>(temp));
		
		for(int i=pos; i<nums.length; i++){
			if(temp.size()==0 || temp.get(temp.size()-1)<=nums[i]) {
			    temp.add(nums[i]);
			    dfs(res, temp, nums, i+1);
			    temp.remove(temp.size()-1);
			} 
		}
	}
}
