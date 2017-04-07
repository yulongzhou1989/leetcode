package leetcode.bitManipulation;

public class MissingNumber_google_268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int missingNumber(int[] nums) {
        int res = 0;
        int i=0;
        //a^b^b =a 
        for(i=0;i<nums.length;i++){
            res^=i^nums[i];
        }
        
        //perfect situation it should be zero
        return res^i;
    }
}
