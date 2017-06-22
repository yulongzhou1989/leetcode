package leetcode.twoPointers;

public class SortColors_75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
		//put all 0 to right, and all 2 to left.  2 pointers save last next Zero pos, and next Second pos
		int n = nums.length;
		int z = 0;
		int sec = n-1;
		for(int i=0;i<nums.length;i++){
			while(nums[i] == 2 && i<sec){
				swap(nums, i, sec--);
			} 
			while(nums[i] == 0 && z<i){
				swap(nums, i, z++);
			}
		}
    }
	
	private void swap(int [] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
