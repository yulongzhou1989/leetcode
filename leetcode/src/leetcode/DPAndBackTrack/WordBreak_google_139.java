package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_google_139 {
	
	public static void main(String [] args){
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("car");
		wordDict.add("ca");
		wordDict.add("rs");
		//System.out.println(wordBreak("cars", wordDict));
	}
	
	//DP way
    public boolean wordBreak1(String s, List<String> wordDict) {
        
        boolean [] dp = new boolean [s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }

	//timeOut
    Map<String, Boolean> map;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0 || wordDict.size()==0) return false;
        map = new HashMap<String, Boolean>();
        helper(s,"", wordDict);
        if(map.containsKey(s)) return map.get(s);
        else return false;
    }

    private void helper(String s, String cur, List<String> wordDict){
        if(map.containsKey(cur)) return;
        for(int i=0; i<wordDict.size();i++){
        	 String temp = cur+wordDict.get(i);
        	 if(temp.length()<=s.length()){
                 if(temp.equals(s)) {
                	 map.put(s, true);
                 }else
                	 helper(s, temp, wordDict);
        	 }
         }
         map.put(cur, false);
    }
     
     
     // private boolean helper(String s, List<String> wordDict){
     //     if(dpMap.containsKey(s)) return dpMap.get(s);
     //     for(int i=0; i<wordDict.size();i++){
     //         if(s.length() == 0) {
     //             dpMap.put(s, true);
     //             return true;
     //         }
     //         if(s.contains(wordDict.get(i))){
     //             s = s.replace(wordDict.get(i),"");
     //             return helper(s, wordDict);
     //         }
     //     }
     //     dpMap.put(s, false);
     //     return false;
     // }
     
//    private void helper(String s, List<String> wordDict){
//        if(dpMap.containsKey(s)) return;
//        for(int i=0; i<wordDict.size();i++){
//            if(s.length() == 0) {
//                dpMap.put(s, true);
//                return;
//            }
//            if(s.contains(wordDict.get(i))){
//                s = s.replace(wordDict.get(i),"");
//                helper(s, wordDict);
//            }
//        }
//        dpMap.put(s, false);
//    }
}
