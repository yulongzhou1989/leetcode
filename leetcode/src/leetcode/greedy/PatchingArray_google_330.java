package leetcode.greedy;

public class PatchingArray_google_330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPatches(int[] nums, int n) {
        int miss=1, i=0, count=0;
        while(miss<=n  && miss>0){
            if(i<nums.length && nums[i]<=miss){
                miss += nums[i++];
            } else {
                miss += miss;
                count++;
            }
        }
        return count;
    }
}
