package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] c = {2,3,6,7};
		System.out.println(combinationSum(c, 7));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		Arrays.sort(candidates);
		getCombinationSum(result, new ArrayList<> (), candidates, target, 0);
		return result;
    }
	
	public static void getCombinationSum (List<List<Integer>> l, List<Integer> tempList, int [] c, int target, int start){
		if (target == 0){
			l.add(new ArrayList<Integer> (tempList));
		} else if (target<0){
			return;
		} else{
			for(int i=start; i<c.length; i++){
				tempList.add(c[i]);
				getCombinationSum (l, tempList, c, target-c[i], i);
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
