package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.HashMap;

public class TargetSum_google_494 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findTargetSumWays(int[] nums, int S) {
        //f(s) = f(s-num[i])+f(s+num[i]);
        return dfs(nums, 0, S, new HashMap<String, Integer>());
    }
    
    private int dfs(int [] nums, int index, int S, HashMap<String, Integer> map){
        if(map.containsKey(index+"->"+S)) return map.get(index+"->"+S);
        if(index == nums.length){
            if(S==0) return 1;
            else return 0;
        }
        
        int minus = dfs(nums, index+1, S-nums[index], map);
        int plus = dfs(nums, index+1, S+nums[index], map);
        map.put(index+"->"+S, minus+plus);
        return minus+plus;
    }
}
