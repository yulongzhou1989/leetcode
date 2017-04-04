package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("zhangqirui","qiruizhang"));
	}
	
//	public static boolean isAnagram(String s, String t) {
//        if(s.length()!=t.length()) return false;
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        for(int i=0;i<s.length();i++){
//            if(!map.containsKey(s.charAt(i))){
//                map.put(s.charAt(i), 1);
//            }else{
//                map.put(s.charAt(i), 1+map.get(s.charAt(i)));
//            }
//        }
//        
//        for(int i=0;i<t.length();i++){
//            Character c = t.charAt(i);
//            if(!map.containsKey(c)){
//                return false;
//            }else {
//                Integer n = map.get(c)-1;
//                if(n<0) return false;
//                if(n==0) map.remove(c);
//                else map.put(c,n);
//            }
//        }
//        
//        if(map.size()!=0) return false;
//        
//        return true;
//    }
	
	public boolean isAnagram(String s, String t) {
        int [] alphabet = new int [26];
        for(int i=0;i<s.length();i++) alphabet[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) alphabet[t.charAt(i)-'a']--;
        for(int i:alphabet) if(i!=0) return false;
        return true;
    }

}
