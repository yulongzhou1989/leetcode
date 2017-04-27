package leetcode.Heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_google_239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0) return new int []{};
		
		int n = nums.length;
		int [] res = new int [n-k+1];
		int ri = 0;
		//store index
		Deque<Integer> q = new ArrayDeque<>();
		for(int i=0;i<nums.length;i++){
			//remove number out of range
			while(!q.isEmpty() && q.peek()<i-k+1){
				q.poll();
			}
			//remove smaller number new boundary
			while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
				q.pollLast();
			}
			//q contains index and add num to res
			q.offer(i);
			if(i>=k-1){
				res[ri++] = nums[q.peek()];
			}
		}
		
		return res;
    }
}
