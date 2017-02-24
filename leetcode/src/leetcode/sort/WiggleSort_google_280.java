package leetcode.sort;

public class WiggleSort_google_280 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void wiggleSort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 1 && nums[i - 1] > nums[i])
				swap(nums, i);
			else if (i > 0 && i % 2 == 0 && nums[i - 1] < nums[i])
				swap(nums, i);
		}
	}

	public void swap(int[] num, int i) {
		int temp = num[i - 1];
		num[i - 1] = num[i];
		num[i] = temp;
	}

}
