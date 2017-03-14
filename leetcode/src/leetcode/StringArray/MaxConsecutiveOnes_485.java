package leetcode.StringArray;

public class MaxConsecutiveOnes_485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
        //compare each consecutive ones group
        int max = 0, cur=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 0){
                max = Math.max(cur,max);
                cur = 0;
            }
            else 
                cur++;
        }
        
        return Math.max(cur,max);
    }
}
