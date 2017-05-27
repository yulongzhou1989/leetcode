package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadderII_126 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dic = new HashSet<>();
        for(String word:wordList){
          dic.add(word);
        }
        if(!dic.contains(endWord)) return res;
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        HashMap<String, List<String>> map = new HashMap<>();
        //get map
        bfs(map, beginSet, endSet, dic, false);

        List<String> sol = new ArrayList<>();
        sol.add(beginWord);
        //get output strings
        dfs(map, res, beginWord, endWord, sol);

        return res;
   }

   public boolean bfs(HashMap<String, List<String>> map, HashSet<String> beginSet, HashSet<String> endSet, HashSet<String> dic,  boolean flip){
         if(beginSet.size()==0) return false;

         if(beginSet.size()>endSet.size())
           return bfs(map, endSet, beginSet, dic, !flip);

         dic.removeAll(beginSet);
         dic.removeAll(endSet);
         boolean done = false;

         HashSet<String> set = new HashSet<>();
         for(String word:beginSet){
             char [] chrs = word.toCharArray();
             for(int i=0;i<chrs.length;i++){
                 for(int j=0;j<26;j++){
                     char old = chrs[i];
                     chrs[i] = (char) (j+'a');
                     String temp = String.valueOf(chrs);
                     String key = flip?temp:word;
                     String value = flip?word:temp;
                     List<String> list = map.getOrDefault(key, new ArrayList<String>());
                     if(endSet.contains(temp)){
                         //System.out.println("list:" + Arrays.toString(list.toArray()));
                         done = true;
                         list.add(value);
                         map.put(key, list);
                     }
                     if(!done && dic.contains(temp)){
                         //System.out.println("list:" + Arrays.toString(list.toArray()));
                         set.add(temp);
                         list.add(value);
                         map.put(key, list);
                     }
                     chrs[i] = old;
                 }
             }
         }

         return done || bfs(map, endSet, set, dic, !flip);
   }


   public void dfs(HashMap<String, List<String>> map, List<List<String>> res, String beginWord, String endWord, List<String> sol){
       if(beginWord.equals(endWord)){
         res.add(new ArrayList<>(sol));
         return;
       }
       if(!map.containsKey(beginWord)) return;
       for(String word:map.get(beginWord)){
         sol.add(word);
         dfs(map, res, word, endWord, sol);
         sol.remove(sol.size()-1);
     }
   }
}
