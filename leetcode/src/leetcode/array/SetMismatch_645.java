package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class SetMismatch_645 {
	public int[] findErrorNums(int[] nums) {
        int [] res = new int [2];
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        if(nums.length==0) return res;
        int a = -1,b=-1;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){//if contains , find the dulplicate
                a = nums[i];
            }
            set.add(nums[i]);
            if(!set.contains(i+1)){
                b = i+1;
            }
        }
        
        return new int [] {a, b};
    }
}
