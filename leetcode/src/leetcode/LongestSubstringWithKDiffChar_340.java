package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithKDiffChar_340 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> l = new ArrayList<String> ();
//		helper("abc", 3, l, new StringBuilder());
//		System.out.println(l);
		System.out.println(lengthOfLongestSubstringKDistinct("caabacaa", 2));
	}
	
	public static int lengthOfLongestSubstringKDistinct (String s, int k){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int best = 0;
		
		for (int i=0;i<s.length();i++){
			//character at the right point;
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size()>k){
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar)-1);
				if (map.get(leftChar) == 0){
					map.remove(leftChar);
				}
				left++;
			}
			best = Math.max(best, i-left+1);
		}
		return best;
	}
	
//	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
//        //find all diff subsets of the string, get the longest one.
//		
//		
//    }
	
	public static void helper (String s, int k,List<String> result, StringBuilder sb){
//		if (s.length()<=k) {
//			result.add(new ArrayList<Integer>);
//			//return k;
//		}
//		else {
		//if (!result.contains(String.valueOf(sb)))
			result.add(String.valueOf(sb));
			for (int i=0;i<s.length();i++){
				//if (i>1 && s.charAt(i)==s.charAt(i-1)) continue;
				sb.append(s.charAt(i));
				helper(s.substring(i+1), k, result, sb);
				sb.deleteCharAt(sb.length()-1);
			}
		//}
	}

}
