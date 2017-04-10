package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
        // bucket sort
		//map to save freq
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//List array to be the bucket
		List<Integer> [] bucket = new List[nums.length+1];
		//initial freq
		for(int n:nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}
		//initial bucket
		for(Integer key:map.keySet()){
			int freq = map.get(key);
			if(bucket[freq] == null){
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}
		List<Integer> res = new ArrayList<>();
		for(int i=bucket.length-1;i>=0 && res.size()<k;i--){
			if(bucket[i]!=null) res.addAll(bucket[i]);
		}
		return res.subList(0,k);
    }
}
