package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisapearedInAnArray_google_448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        //nagetive number
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            if(nums[val]>0)
               nums[val] = -nums[val];
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) res.add(i+1);
        }
        return res;
    }

}
