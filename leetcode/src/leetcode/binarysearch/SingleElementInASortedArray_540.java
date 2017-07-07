package leetcode.binarysearch;

public class SingleElementInASortedArray_540 {

	public int singleNonDuplicate(int[] nums) {
		if(nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		
		int l = 0;
		int h = nums.length-1;
		
		while(l<h){
			int mid = l + (h-l)/2;
            if(mid%2==0){
                if(mid>0 && nums[mid] == nums[mid-1]){
                    h = mid-2;
                }else if(mid<nums.length-1 && nums[mid] == nums[mid+1]){
                    l = mid+2;
                }else{
                    return nums[mid];
                }
            }else{
                if(mid>0 && nums[mid] == nums[mid-1]){
                    l = mid+1;
                }else if(mid<nums.length-1 && nums[mid] == nums[mid+1]){
                    h = mid-1;
                }
            }
		}
		
		return nums[l];
    }

}
