package leetcode.bitManipulation;

import java.util.HashSet;

public class MaxinumXORofTwoNumbersInAnArray_google_421 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {1,2,3};
		System.out.println(findMaximumXOR(nums));
	}

	public static int findMaximumXOR(int[] nums) {
		int max=0, mask=0;
		for(int i=31;i>=0;i--){
			mask = mask|(1<<i);
			//reserve left bits
			HashSet<Integer> set = new HashSet<>();
			for(int num:nums){
				set.add(num&mask);
			}
			//if this bit i can be added to max, a^b=c, c^b=a 
			int temp = max|(1<<i);
			for(int prefix:set){
				if(set.contains(temp^prefix)){
					max=temp;
					break;
				}
			}
		}
		return max;
    }
}
