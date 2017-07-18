package leetcode.stack;

import java.util.Stack;

public class A132Pattern_456 {
	public boolean find132pattern(int[] nums) {
        if(nums==null || nums.length<3) return false;
        //find the maxJ which is max number which is smaller than j
		int maxJ = Integer.MIN_VALUE;//if we can find a maxJ, which means we already have a[j]<a[k]
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();//increasing seq stack
		for(int i=n-1;i>=0;i--){
			if(nums[i]<maxJ) return true;
			while(!stack.isEmpty() && nums[i]>stack.peek()){
				maxJ = stack.pop();
			}
			stack.push(nums[i]);
		}
		
		return false;
    }
}
