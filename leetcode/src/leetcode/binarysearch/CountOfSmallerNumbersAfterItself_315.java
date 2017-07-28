package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterItself_315 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> countSmaller(int[] nums) {
        //search the code from end to top,
		//do the binary search, find the insert index
		//then save the index to nums 
		Integer [] res = new Integer [nums.length];
		List<Integer> sorted = new ArrayList<>();
		for(int i=nums.length-1;i>=0;i--){
			int index = findIndex(sorted, nums[i]);
			res[i] = index;
			sorted.add(index, nums[i]);
		}
		
		return Arrays.asList(res);
    }
	
	private int findIndex(List<Integer> sorted, int num){
		if(sorted.size()==0) return 0;
		int start = 0;
		int end = sorted.size()-1;
		if(num<=sorted.get(start)) return start;
		if(num>sorted.get(end)) return end+1;
		
		//do binary search
		while(start<end){
			int mid = start+(end-start)/2;
			if(sorted.get(mid)<num){
				start = mid+1;
			}else{
				end = mid;
			}
		}
		
		return start;
	}

}
