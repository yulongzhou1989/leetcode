package leetcode.sort;

import java.util.Arrays;

public class WiggleSortII_google_324 {
	
	public void wiggleSort(int[] nums) {
        int mid = findMedian(nums);
		int n = nums.length;
		int left = 0, i=0, right = n-1;
		while(i<=right){//to left nums>mid in first odd slot, and nums<mid in last even slot
			if(nums[getNewIndex(i,n)]>mid){
				swap(nums, getNewIndex(left++,n), getNewIndex(i++, n));
			}else if(nums[getNewIndex(i, n)]<mid){
				swap(nums, getNewIndex(right--,n), getNewIndex(i,n));
			}else{
				i++;
			}
		}
    }
	
	private void swap(int [] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private int getNewIndex(int i, int n){
		return (1+2*i)%(n|1);//(n|1) find closest odd number which is equal or larger than n;  
	}
	
	private int findMedian(int [] nums){
		Arrays.sort(nums);
		int n = nums.length;
		return nums[n/2];
	}
}
