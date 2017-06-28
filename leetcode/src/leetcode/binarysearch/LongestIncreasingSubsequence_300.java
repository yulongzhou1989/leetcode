package leetcode.binarysearch;

public class LongestIncreasingSubsequence_300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int lengthOfLIS(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		//make an array save binary search result
		int len = 0;
		int [] tails = new int [nums.length];
		for(int n:nums){
			int i = binarySearchIndex(tails, 0, len-1, n);
			if(i<0) i = -(i+1);
			if(i==len) len++;
			tails[i] = n;
		}
		
		return len;
    }
	
	//stable bs to find a index
	private int binarySearchIndex(int [] nums, int l, int h, int x){
		
		while(l<=h){
			int mid = l+(h-l)/2;
			if(nums[mid]==x){
				return mid;
			}else if(nums[mid]<x){
				l = mid+1;
			}else if(nums[mid]>x){
				h = mid-1;
			}
		}
		
		return -l-1;
	}
}

