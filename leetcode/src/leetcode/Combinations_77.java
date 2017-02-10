package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4,2));
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> l = new ArrayList<List<Integer>> ();
		getCombine(l, new ArrayList<Integer> (), n, k, 1);
		return l;
	}
	
	public static void getCombine(List<List<Integer>> l, List<Integer> tempList, int n
			, int k, int start){
		if(tempList.size() == k){
			l.add(new ArrayList<Integer>(tempList));
		} else{
			for (int i=start;i<n+1;i++){
				tempList.add(i);
				getCombine(l, tempList, n, k, i+1);
				tempList.remove(tempList.size()-1);
			}
		}
		
	}
}
