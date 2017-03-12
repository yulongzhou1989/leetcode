package leetcode.DPAndBackTrack;

public class HouseRobber_198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//several choices
    public int rob(int[] nums) {
        //2 choices, rob or unrob
        int rob = 0;
        int unrob = 0;
        
        for (int i=0;i<nums.length;i++){
            //if rob, need  previous house unrob
            int preRob = rob;
            rob = unrob + nums[i];
            //if unrob this, get the max value of previous rob and unrob
            unrob = Math.max(preRob, unrob);
        }
        return Math.max(rob, unrob);
    }
}
