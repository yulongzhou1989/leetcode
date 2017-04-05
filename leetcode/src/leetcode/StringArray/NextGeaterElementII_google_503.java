package leetcode.StringArray;

import java.util.Arrays;
import java.util.Stack;

public class NextGeaterElementII_google_503 {
	
	public void main(String [] args){
		
	}
	
	public int[] nextGreaterElements(int[] nums) {
        int [] res = new int [nums.length];  
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            j=j%nums.length;
            while(j!=i && nums[j]<=nums[i]) j=(j+1)%nums.length;
            res[i] = j==i?-1:nums[j];
        }
        
        return res;
    }
	
	 public int[] nextGreaterElements1(int[] nums) {
	        int [] res = new int [nums.length];
	        Arrays.fill(res, -1);
	        Stack<Integer> stack = new Stack<Integer>();
	        for(int i=0;i<2*nums.length;i++){
	            int num = nums[i%nums.length];
	            while(!stack.isEmpty() && nums[stack.peek()]<num) res[stack.pop()] = num;
	            if(i<nums.length) stack.push(i);
	        }
	        
	        return res;
	  }

}
