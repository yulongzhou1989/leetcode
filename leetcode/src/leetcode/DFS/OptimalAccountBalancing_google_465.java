package leetcode.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OptimalAccountBalancing_google_465 {
	public int minTransfers(int[][] transactions) {
		//adjust balance, then find the min way to clear balance
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int [] t:transactions){//adjust balance
			map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
			map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(Integer key:map.keySet()){
			if(map.get(key)!=0)
				list.add(map.get(key));
		}
		
		int [] bal = new int [list.size()];
		for(int i=0;i<list.size();i++){
			bal[i] = list.get(i);
		}
		//System.out.println(Arrays.toString(bal));
		int res = dfs(bal, 0, 0);
		
		return res;
    }
	
	private int dfs(int [] bal, int start, int count){
		//skip balance zero
		while(start<bal.length && bal[start]==0){
			start++;
		}
        if(start >= bal.length){
			return count;
		}
		int res = Integer.MAX_VALUE; HashSet<Integer> set = new HashSet<>();
		for(int i=start+1;i<bal.length;i++){
			if(!set.contains(bal[i]) && bal[start] * bal[i]<0){//diff sign
				bal[i] += bal[start];
				res = Math.min(res, dfs(bal, start+1, count+1));
				bal[i] -= bal[start];
                set.add(bal[i]);
			}
		}
		
		return res;
	}
}
