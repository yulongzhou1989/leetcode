package leetcode.DFS;

public class ScrambleString_87 {

	public boolean isScramble(String s1, String s2) {
		if(s1==null || s2==null || s1.length()!=s2.length()) return false;
		if(s1.length()==0 && s2.length()==0) return true;
        if(s1.equals(s2)) return true;
		int n = s1.length();
		int [] diff = new int [26];
		for(int i=0;i<n;i++){
			diff[s1.charAt(i)-'a']++;
			diff[s2.charAt(i)-'a']--;
		}
		
		for(int i=0;i<26;i++){
			if(diff[i]!=0) return false;
		}
		
		for(int i=1;i<n;i++){
			if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if(isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i)))
				return true;
		}
	
		return false;
	}
}
