package leetcode.twoPointers;

public class SortTransformedArray_google_360 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -4, -2, 2, 4 };
		System.out.println(sortTransformedArray(nums, 0, 3, 5));
	}

	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] res = new int[nums.length];
		int i = 0, j = nums.length - 1;
		int k = a >= 0 ? (nums.length - 1) : 0;
		while (i <= j) {
			if (a >= 0) {
				res[k--] = formula(nums[i], a, b, c) > formula(nums[j], a, b, c) ? formula(nums[i++], a, b, c)
						: formula(nums[j--], a, b, c);
			}
			if (a < 0) {
				res[k++] = formula(nums[i], a, b, c) < formula(nums[j], a, b, c) ? formula(nums[i++], a, b, c)
						: formula(nums[j--], a, b, c);
			}
		}
		return res;
	}

	public static int formula(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
}
