package leetcode.binarysearch;

public class MaximumAverageSubarrayII_google_644 {

	public double findMaxAverage(int[] nums, int k) {
        //find the existed max value
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		for(int num:nums){
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		double exit = max, pre = max;
		while(exit>0.0000001){
			double mid = (min+max)/2;
			if(check(nums,mid,k)){//check if available
				min = mid;
			}else{
				max = mid;
			}
			exit = Math.abs(pre-mid);
			pre = mid;
		}
		
		return min;
    }
	
	private boolean check(int [] nums, double mid, int k){//sumi-sumj>=0 i>=j+k
		double sum = 0, pre = 0, minPre = 0;
		for(int i=0;i<k;i++){//if first key element meet condition
			sum += nums[i]-mid;
		}
		if(sum>=0) return true;
		for(int i=k;i<nums.length;i++){
			pre += nums[i-k]-mid;
			sum += nums[i]-mid;
			minPre = Math.min(pre, minPre);
			if(sum-minPre>=0) return true;
		}
		
		return false;
	}
}
