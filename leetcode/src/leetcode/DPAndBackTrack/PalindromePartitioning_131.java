package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning_131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(partition("aab").toArray()));
	}

	//find all combination in which each of them are permutation 
	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); 
        helper(res, s, 0, new ArrayList<>());
		return res;
    }
	
	public static void helper(List<List<String>> res, String s,int pos, List<String> temp){
		if(pos>=s.length()){
			res.add(new ArrayList<>(temp));
		}
		for(int i=pos;i<s.length();i++){
			if(isPalindrome(s, pos, i)){
				temp.add(s.substring(pos, i+1));
				helper(res, s, i+1, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String s, int i, int j){
		while(i<j){
			if(s.charAt(i++)!=s.charAt(j--)) return false;
		}
		return true;
	}
}
