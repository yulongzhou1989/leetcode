package leetcode.DFS;

import java.util.Arrays;
import java.util.Comparator;

public class MatchstickstoSquare_473 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean makesquare(int[] nums) {
        //filter out special case
		if(nums==null || nums.length<4) return false;
		int sum = 0;
		Integer [] numbers = new Integer [nums.length];
		for(int i=0;i<nums.length;i++){
			sum += nums[i];
			numbers [i] = nums[i];
		}
		if(sum%4!=0) return false;

		Arrays.sort(numbers, new Comparator<Integer> (){
			@Override 
			public int compare (Integer a, Integer b){
				return b-a;
			}
		});
		//System.out.println("numbers: " + Arrays.toString(numbers));
		return dfs(numbers, sum/4, new int [4], 0);
    }
	
	private boolean dfs(Integer [] numbers, int target, int [] arr, int index){
		if(index == numbers.length){
			if(arr[0] == target && arr[1] == target && arr[2] == target)
				return true;
			else return false;
		}
		
		for(int i=0;i<4;i++){
			if(numbers[index] + arr[i]>target) continue;
			arr[i] += numbers[index];
			if(dfs(numbers, target, arr, index+1)) return true;
			arr[i] -= numbers[index];
		}
		
		return false;
	}

}
