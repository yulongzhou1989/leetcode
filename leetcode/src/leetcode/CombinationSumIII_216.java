package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(3,9));
	}

	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		getCombinationSum3(l, new ArrayList<Integer> (), k, n, 1, n);
		return l;
    }
	
	public static void getCombinationSum3(List<List<Integer>> l, List<Integer> tempList,
			int k, int n, int start, int remain){
		if (remain<0){
			return;
		} else if (remain == 0 && tempList.size() == k){
			l.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i= start; i<n && i<=9; i++){
				if (tempList.size()>k) continue;
				tempList.add(i);
				getCombinationSum3(l, tempList, k, n, i + 1, remain-i);
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
