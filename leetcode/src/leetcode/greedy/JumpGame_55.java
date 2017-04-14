package leetcode.greedy;

public class JumpGame_55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump(int[] nums) {
        //if nums[next] + next > reach(current position) 
        int reach = 0, i;
        for(i=0;i<nums.length && i<=reach;i++){
            reach = Math.max(i+nums[i], reach);
        }
        return i==nums.length;
    }
}
