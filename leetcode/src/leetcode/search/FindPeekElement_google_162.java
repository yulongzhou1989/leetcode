package leetcode.search;

public class FindPeekElement_google_162 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int findPeakElement1(int[] nums) {
	        if (nums.length==1) return 0;
	        
	        for(int i=0;i<nums.length;i++){
	            if(i==0 && nums[i]>nums[i+1]) return i;
	            if(i==nums.length-1 && nums[i]>nums[i-1]) return i;
	            if(i!=0 && i!=nums.length-1 && nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
	        }
	        
	        return 0;
	  }
	 
	 public int findPeakElement2(int[] nums) {
	        //binary search
	        int low = 0;
	        int high = nums.length-1;
	        
	        while(low<high){
	            int mid1 = (low+high)/2;
	            int mid2 = mid1+1;
	            if(nums[mid1]<nums[mid2]){
	                low = mid2;
	            }
	            else{
	                high = mid1;
	            }
	        }
	        
	        return low;
	    }
	 
	 
}
