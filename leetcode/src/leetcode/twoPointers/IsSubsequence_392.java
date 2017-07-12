package leetcode.twoPointers;

public class IsSubsequence_392 {
	public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
		else if(t.length()<s.length()) return false;
		else if(t.length() == s.length()) return s.equals(t);
		
		int indexS=0, indexT = 0;
		
		while(indexS<s.length() && indexT<t.length()){
			if(s.charAt(indexS) == t.charAt(indexT)){
				indexS++;
			}
			if(indexS == s.length()) return true;
			indexT++;
		}
		
		return false;
    }
}
