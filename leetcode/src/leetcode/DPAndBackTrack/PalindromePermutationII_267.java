package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII_267 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList();
        //If only one letter
		if(s.length()<2){
		    res.add(s);
		    return res;
		}
        //filter out records which can not be palindromes
		int odd = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
			odd += map.get(c)%2!=0?1:-1;
		}
		if(odd>1) return res;
        
        //make half of the permutation string and find the middle key
		String key = "";
		StringBuilder halfPair = new StringBuilder();
		for(Character c:map.keySet()){
			if(map.get(c)%2!=0) key += c;
			for(int i=0; i<map.get(c)/2;i++){
				halfPair.append(c);
			}
		}
		//get permutation list
        res = helper(halfPair, new HashMap<String, List<String>>(), key, halfPair.length());
        return res;
    }
	
	private List<String> helper(StringBuilder sb, HashMap<String, List<String>> memo, String key, int len){
	    //System.out.println("S:" + sb.toString());
		if(memo.containsKey(sb.toString())) return memo.get(sb.toString());
		List<String> res = new ArrayList<>();
		if(sb.length()==0){
			res.add("");
			return res;
		}
		for(int i=0;i<sb.length();i++){
		    if(i>0 && sb.charAt(i)==sb.charAt(i-1)) continue;
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			List<String> subList = helper(sb, memo, key, len);
			for(String sub:subList){
				StringBuilder temp = new StringBuilder();
				temp.append(c).append(sub);
				if(temp.length() == len) res.add(temp.toString()+key+temp.reverse().toString());
				else res.add(temp.toString());
			}
			sb.insert(i,c);
		}
		
		memo.put(sb.toString(), res);
		return res;
	}

}
