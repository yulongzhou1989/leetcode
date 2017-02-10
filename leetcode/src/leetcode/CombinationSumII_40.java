package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] c = {13,23,25,11,7,26,14,11,27,27,26,12,8,20,22,34,27,17,5,26,31,11,16,27,13,20,29,18,7,14,13,15,25,25,21,27,16,22,33,8,15,25,16,18,10,25,9,24,7,32,15,26,30,19};
		System.out.println(combinationSum2(c, 25));
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<List<Integer>> ();
        Arrays.sort(candidates);
        getCombination(l, new ArrayList<Integer>(), candidates, target, 0);
        return l;
    }
	
	public static void getCombination(List<List<Integer>> l, List<Integer> tempList, int [] c, 
			int target, int start){
		if (target < 0){
			return;
		} 
		//else if (target == 0 && !l.contains(tempList)){
		else if (target == 0){
			l.add(new ArrayList<Integer>(tempList));
		} else{
			for (int i=start;i<c.length;i++){
				if (c[i]>target || i>start && c[i-1] == c[i]) continue;
				//if (c[i]>target) continue;
				tempList.add(c[i]);
				getCombination(l, tempList, c, target-c[i], i + 1);
				tempList.remove(tempList.size()-1);
			}
		}
	}

}
