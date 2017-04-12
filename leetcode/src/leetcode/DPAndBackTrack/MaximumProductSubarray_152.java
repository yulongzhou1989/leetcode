package leetcode.DPAndBackTrack;

public class MaximumProductSubarray_152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProduct(int[] nums) {
		//negtive max could change to max when meet negtive number
		int res = nums[0];
		int iMax = nums[0];
		int iMin = nums[0];
		
		for(int i=1;i<nums.length;i++){
			//swap if current number is a negtive one
			if(nums[i]<0) {
				int temp = iMax;
				iMax = iMin;
				iMin = temp;
			}
			
			iMax = Math.max(iMax*nums[i], nums[i]);
			iMin = Math.min(iMin*nums[i], nums[i]);
			
			res = Math.max(iMax, res);
		}
	
		return res;
	}
}
