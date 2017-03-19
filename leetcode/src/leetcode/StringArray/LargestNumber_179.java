package leetcode.StringArray;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//O(nlogn) time
	public String largestNumber(int[] nums) {
        //compare s1 + s2 >S2+s1?
        String [] s_nums = new String [nums.length];
        for (int i=0;i<nums.length;i++){
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort (s_nums, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });
        
        String res = "";
        for(String s_num:s_nums){
            res+=s_num;
        }
        if (res.length()>0 && res.charAt(0) == '0') res = "0";
        
        return res;
    }
}
