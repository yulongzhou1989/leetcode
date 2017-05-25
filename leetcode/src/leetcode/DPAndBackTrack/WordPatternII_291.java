package leetcode.DPAndBackTrack;

import java.util.HashMap;
import java.util.HashSet;

public class WordPatternII_291 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//first split string, second check fit pattern
	public boolean wordPatternMatch(String pattern, String str) {		
		return helper(str, pattern, new HashMap<Character, String>(), new HashSet<String>(), 0, 0);
    }
	
	public boolean helper(String str, String pat, HashMap<Character, String> map, HashSet<String> set, int i, int j){
		//base case
		if(i==str.length() && j==pat.length()) return true;
		if(i==str.length() || j==pat.length()) return false;
		
		//current pattern
		char c = pat.charAt(j);
		
		//if pattern existed
		if(map.containsKey(c)){
			String s = map.get(c);
			//check start with i, has a s
			if(!str.startsWith(s, i)) return false;
			
			return helper(str, pat, map, set, i+s.length(), j+1);
		}
		
		//if pattern is not existed
		for(int k=i; k<str.length();k++){
			String p = str.substring(i,k+1);
			if(set.contains(p)) continue;
			
			//create or update
			map.put(c, p);
			set.add(p);
			
			if(helper(str, pat, map, set, k+1, j+1)) return true;
			
			//rest 
			map.remove(c);
			set.remove(p);
		}
		
		return false;
	}
}
