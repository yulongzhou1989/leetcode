package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangers_google_228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> summaryRanges(int[] nums) {
        if (nums.length==0) return new ArrayList<String>();
        //start from first number, if nums[i+1] not equals to nums[i]+1, a new range
        List<String> result = new ArrayList<String>();
        int start = nums[0];
        for (int i=0;i<nums.length;i++){
            if (nums.length-1==i){
                String range = nums[i]==start?start+"":start+"->"+nums[i];
                result.add(range);
                continue;
            }
            if (nums[i+1]!=nums[i]+1){
                String range = nums[i]==start?start+"":start+"->"+nums[i];
                result.add(range);
                start=nums[i+1];
            }
        }
        
        return result;
    }
}
