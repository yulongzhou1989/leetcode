package leetcode.StringArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//On3  two pointers
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length<4) return res;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<nums.length-2;j++){
				if(j>i+1 && nums[j]==nums[j-1]) continue;
				int low = j+1, high = nums.length-1;
				while(low<high){
					int sum = nums[i]+nums[j]+nums[low]+nums[high];
					if(sum == target){
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						//remove dulplicate
						while(low<high&&nums[low]==nums[low+1]) low++;
						while(low<high&&nums[high]==nums[high-1]) high--;
						low++;
						high--;
					}
					else if(sum<target) low++;
					else high--;
				}
			}
		}
		
		return res;
	}

	//On4
	public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
		getFourSum(res, new ArrayList<>(), nums, 4, target, 0);
		return res;
    }
	
	public void getFourSum(List<List<Integer>> res, List<Integer> tempList, int nums[], int countLeft, int target, int pos){
		if(countLeft<0) return;
		if(countLeft==0){
			if (target == 0 && !res.contains(tempList)) res.add(new ArrayList(tempList)); 
		}
		else{
    		for(int i=pos;i<nums.length-countLeft+1;i++){
    			tempList.add(nums[i]);
    			getFourSum(res, tempList, nums, countLeft-1, target-nums[i], i+1);
    			tempList.remove(tempList.size()-1);
    		}
		}
	}
}
