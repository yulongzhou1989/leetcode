package leetcode.twoPointers;

public class CreateMaximumNumber_google_321 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// summary:1. 2 pointers  one slow one fast -> solve the largest seq for certain length, (use a array to mock stack)
	// 		   2. compare 2 array one is greater then the other one-> skip all the same element	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		if(k==0 || nums1.length + nums2.length<k) return new int [] {};
		int n1 = nums1.length;
		int n2 = nums2.length;
		int [] res = new int [k];
		for(int i=Math.max(0, k-n2);i<=k && i<=n1;i++){
			int [] candidate = merge(getMaxSeq(nums1, i), getMaxSeq(nums2, k-i), k);
			res = greater(candidate, 0, res, 0)?candidate:res;
		}
		
		return res;
    }
	
	//get maxSeq
	private int [] getMaxSeq(int [] nums, int k){
		int n = nums.length;
		int [] res = new int [k];
		for(int i=0, j=0;i<n;i++){
			while(n-i+j>k && j>0 && res[j-1]<nums[i])j--;
			if(j<k) res[j++] = nums[i];
		}
		
		return res;
	}
	
	//merge 2 array
	private int [] merge(int [] nums1, int [] nums2, int k){
		int i=0, j=0, m=0; 
		int [] res = new int [k];
		while(i<nums1.length || j<nums2.length){
			if(j>=nums2.length){
				res[m++] = nums1[i++]; 
			}else if(i>=nums1.length){
				res[m++] = nums2[j++];
			}else if(nums1[i] == nums2[j]){//
				res[m++] = greater(nums1, i, nums2, j)?nums1[i++]:nums2[j++];
			}else if(nums1[i]>nums2[j]){
				res[m++] = nums1[i++];
			}else {
				res[m++] = nums2[j++];
			}
		}
		
		return res;
	}
	
	private boolean greater(int [] nums1, int i, int [] nums2, int j){
		int n1 = nums1.length;
		int n2 = nums2.length;
		while(i<n1 && j<n2 && nums1[i] == nums2[j]){
			i++;
			j++;
		}
		
		return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
	}

}
