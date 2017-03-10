package leetcode.StringArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindrome_google_409 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else 
                map.put(s.charAt(i),1+map.get(s.charAt(i)));
        }
        
        int len = 0;
        boolean hasSingleChar = false;
        for(Integer val:map.values()){
            if (val%2==0) len+=val;
            if (val%2==1) {
                len += val-(val%2);
                hasSingleChar = true;
            }
        }
        
        return hasSingleChar?(len+1):len;
    }
	
	//hashSet
	public int longestPalindrome1(String s) {
        if (s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count =0;
        for (int i=0;i<s.length();i++){
            if (hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else {
                hs.add(s.charAt(i));
            }
        }
        
        return hs.size()==0?(count*2):(count*2+1);
    }
}
