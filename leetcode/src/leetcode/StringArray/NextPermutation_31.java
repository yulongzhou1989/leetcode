package leetcode.StringArray;

public class NextPermutation_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {1,3,2};
		System.out.println(String.valueOf(nextPermutation(nums)));
	}

	public static int [] nextPermutation(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return new int []{};
        int n = nums.length;
        int i = n-1;
        //find position of ascend order
        while(i>0){
            if(nums[i]>nums[i-1]) break;
            i--;
        }
        //no ascend, reverse
        if(i==0){
            reverse(nums, 0, n-1);
        }
        //find the first number that smaller than nums[i]
        else {
        	int val = nums[i-1];
            for(int j=n-1;j>=i;j--){
                if(nums[j]>val) {
                    swap(nums, i-1, j);
                    break;
                }
            }
            //reverse descend order to find the smallest greater one
            reverse(nums, i, n-1);
        }
        
        return nums;
    }
    
    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void reverse(int [] nums, int start, int end){
        for(int i=start;i<=(start+end)/2;i++){
            swap(nums,i,end+start-i);
        }
    }
}
