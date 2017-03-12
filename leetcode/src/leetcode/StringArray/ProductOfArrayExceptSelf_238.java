package leetcode.StringArray;

public class ProductOfArrayExceptSelf_238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int [] res = new int [nums.length];
        //get product of num[i]'s left
        res[0] = 1;
        for (int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        //get product of nums[i]'s right 
        int right =1;
        for (int i=nums.length-1;i>=0;i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
