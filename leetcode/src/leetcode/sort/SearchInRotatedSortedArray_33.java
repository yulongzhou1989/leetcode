package leetcode.sort;

public class SearchInRotatedSortedArray_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(int[] nums, int target) {
        int start=0, end = nums.length-1;
		//binary search
		while(start<=end){
			int mid = (start+end)/2;
			if(nums[mid] == target) return mid;
			if(nums[start]<=nums[mid]){
				if(nums[mid]>target && target>=nums[start]) end = mid-1; 
				else start = mid+1;
			}
			if(nums[mid]<=nums[end]){
				if(nums[mid]<target && target<=nums[end]) start = mid+1;
				else end = mid-1;
			}
		}
		
		return -1;
    }
}
