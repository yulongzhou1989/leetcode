package leetcode.sort;

public class ShortestUnsortedContinuousSubarray_google_581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//nlogn 
	public int findUnsortedSubarray1(int[] nums) {
        if(nums.length==0 || nums.length==1) return 0;
        int start = -2;
        int end = -1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                int j=i;
                while(j>0 && nums[j]<nums[j-1]){
                    swap(nums, j, j-1);
                    j--;
                }
                if(start==-2 || start>j-1) start = j-1;
                end = i;
            }
        }
        
        if(end==-1) return 0;
        return end-start;
        
    }
    
    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //public int 
}
 