package leetcode.twoPointers;

public class MoveZeros_283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroes(int[] nums) {
        int insertPointer=0;
//        for (int i=0; i<nums.length; i++){
//            if (nums[i] != 0){
//                nums[insertPointer++] = nums[i];
//            }
//        }
        
        for(int num : nums){
        	if (num!=0){
        		nums[insertPointer++] = num;
        	}
        }
        //left pos 0
        while (insertPointer<nums.length){
            nums[insertPointer++] = 0;
        }
    }
}
