package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII_350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num:nums1){
			map.put(num, map.getOrDefault(num,0)+1);
		}
		List<Integer> list = new ArrayList<>();
		for(int num:nums2){
			if(map.containsKey(num) && map.get(num)>0){
				map.put(num, map.get(num)-1);
				list.add(num);
			}
		}
		
		int [] res = new int [list.size()];
		for(int i=0;i<res.length;i++){
			res[i] = list.get(i);
		}
		
		return res;
    }
}
