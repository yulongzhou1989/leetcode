package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreakII_google_140 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("dog");
		list.add("cats");
		list.add("and");
		list.add("sand");
		list.add("cat");
		
		//System.out.println(Arrays.toString(wordBreak("catsanddog", list).toArray()));
	}
	
	//Add memo
	public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
		for(String word:wordDict){
			set.add(word);
		}
		//backtrack find all list
		return getBreakWords(set, s, new HashMap<String, List<String>>());
    }
	
	private List<String> getBreakWords(HashSet<String> set, String s, HashMap<String, List<String>> map){
		if(map.containsKey(s)) return map.get(s);
		List<String> res = new ArrayList<>();
		if(s.length()==0){
			res.add("");
			return res;
		}
		for(int i=0;i<s.length()+1;i++){
			if(set.contains(s.substring(0,i))){
			    List<String> subList = getBreakWords(set, s.substring(i), map);
			    for(String sub:subList){
			        res.add(s.substring(0,i) + (sub.isEmpty()?"":" ") + sub);
			    }
			}
		}

        map.put(s, res);
		return res;
	}

	
	//TODO: add memo
    public List<String> wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
		for(String word:wordDict){
			set.add(word);
		}
		List<String> res = new ArrayList<>();
		//backtrack find all list
		getBreakWords(res, set, "", s);
		return res;
    }
	
	private void getBreakWords(List<String> res, HashSet<String> set, String cur, String s){
		if(s.length()==0){
			if(cur.length()>=1){
				String temp = cur.substring(0, cur.length()-1);
				if(!res.contains(temp)) res.add(temp);
			}
		} 
		for(int i=0;i<s.length()+1;i++){
			if(set.contains(s.substring(0,i))){
				getBreakWords(res, set, cur+s.substring(0,i)+" ", s.substring(i));
			}
		}
	}
}
