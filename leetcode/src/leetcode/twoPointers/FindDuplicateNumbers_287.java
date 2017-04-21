package leetcode.twoPointers;

public class FindDuplicateNumbers_287 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//refer 142
	public int findDuplicate(int[] nums) {
        if(nums.length<2) return -1;
        int slow = nums[0];
		int fast = nums[nums[0]];
		//fast go 2 steps, and slow go 1
		while(fast!=slow){
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		//set fast to the head
		fast = 0;
		while(fast!=slow){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
    }
}
