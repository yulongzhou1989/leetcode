package leetcode.twoPointers;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesII_google_487 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMaxConsecutiveOnes1(int[] nums) {
        
        //two pointers,first one track the current position(i), second track the last zero position(j)
        //The difference of these two are the max consecutive
        //zeros:number of zeros in current seq, k the largest number of zero
        int zeros = 0, k=1, maxCons=0;
        for (int i=0,j=0;i<nums.length;i++){
            if (nums[i] == 0)
                zeros++;
            while (zeros>k){
                if (nums[j++] == 0)
                    zeros--;
            }
            maxCons=Math.max(maxCons, i-j+1);
        }
        return maxCons;
    }
	
	//for the follow up
	//What if the input numbers come in one by one as an infinite stream? In other words,
	//you can't store all numbers coming from the stream as it's too large to hold in memory. 
	//Could you solve it efficiently?
	//use queue to track the position of zero
	
	public int findMaxConsecutiveOnes(int[] nums){
		
		//use queue to track the position of previous zero
		Queue<Integer> zeroQ = new LinkedList<>();
		int max = 0, k=1;
		for (int i=0,j=0;i<nums.length;i++){
			if(nums[i] == 0)
				zeroQ.offer(i);
			if (zeroQ.size()>k){
				j = zeroQ.poll()+1;
			}
			max = Math.max(max,i-j+1);
		}
		
		return max;
	}
	

}
