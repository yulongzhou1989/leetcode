package leetcode.bitManipulation;

public class SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] singleNumber(int[] nums) {
        //first divid this array to 2 groups by i digit diff
		//we can get a i by xor each nums in the array, as through one iterate, 
		//we can get XOR result of targeted 2 nums
		//XOR for each group, then we can get these 2 numbers
		int xor = 0;
		for(int i=0;i<nums.length;i++){
			xor^=nums[i];
		}
		//get smallest significant bit
		int ssb = (xor&(xor-1))^xor;
		int res1 = 0;
		int res2 = 0;
		
		for(int i=0;i<nums.length;i++){
			if((ssb&nums[i]) == 0){
				res1 ^= nums[i];
			} else{
				res2 ^= nums[i];
			}
		}
		
		return new int [] {res1, res2};	
    }
}
