package leetcode.StringArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorElement_169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,2,3};
		System.out.println(majorityElement(nums));
	}

	//map
	public static int majorityElement(int[] nums) {
		
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
            if (map.get(nums[i])>nums.length/2)
                return map.get(nums[i]);
        }
        
        return 0;
    }
	
	//sort
	public int majorityElement1(int[] nums) {
        
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	// Moore voting algorithm
	public int majorityElement2(int[] nums) {
        
        int count = 0;
        int ret = 0;
        
        for(int num: nums){
            if (count == 0){
                ret = num;
            } 
            
            if (num == ret) count++;
            else count--;
        }
        
        return ret;
    }
}
