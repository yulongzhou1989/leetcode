package leetcode.sort.DivideAndConque;

public class ReversePairs_google_493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//find j>i and nums[i]>2*nums[j]
	public int reversePairs(int[] nums) {
        return countReversePairs(nums, 0, nums.length);
    }
	
	public int countReversePairs(int [] nums, int start, int end){
		if(end-start<=1) return 0;
		int mid = (start+end)/2;
		int res = countReversePairs(nums, start, mid) 
				+ countReversePairs(nums, mid, end);
		int j = mid,k=mid;
		int [] cache = new int [end-start];
		for(int i=start, ci=0;i<mid;i++,ci++){
		    //find record fit requirement
		    while(k<end && nums[i]/2.0>nums[k]) k++;
			while(j<end && nums[j]<nums[i]){
				cache[ci++] = nums[j++];
			}
			cache[ci] = nums[i];
			res += k-mid;
		}
		
		System.arraycopy(cache, 0, nums, start, j-start);
//	 	    System.out.println("cache:" + Arrays.toString(cache) + ",res:"+res);
//	 		System.out.println("nums:" + Arrays.toString(nums));
		
		return res;
	}

}
