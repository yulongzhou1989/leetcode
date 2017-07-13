package leetcode.DFS;

import java.util.HashMap;

public class ScrambleString_87 {
	
	public static void main(String [] args){
		//System.out.println(isScramble("great","rgtae"));
	}

	HashMap<String, Boolean> map = new HashMap<>();
	
	public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
		if(s1.length()==0) return true;
		if(s1.equals(s2)) return true;
		if(map.containsKey(s1+"#"+s2)) return map.get(s1+"#"+s2);
		
		int n = s1.length();
		int [] arr = new int [26];
		
		for(int i=0;i<n;i++){
			arr [s1.charAt(i)-'a'] ++;
			arr [s2.charAt(i)-'a'] --;
 		}
		
		for(int i=0; i<26;i++){
			if(arr[i]!=0) return false;
		}
		
		for(int i=1;i<n;i++){
			if((isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)))||
			   (isScramble(s1.substring(0,i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0,n-i)))){
				map.put(s1 + "#" + s2, true);
				return true;
			}
				
		}
		
		map.put(s1 + "#" + s2, false);
		return false;
    }
}
