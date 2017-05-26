package leetcode.BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Two ways bfs, use hash instead the Queue to save status
		public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			//save wordList to dic
			HashSet<String> dic = new HashSet<>();
			for(String word:wordList){
				dic.add(word);
			}
			if(!dic.contains(endWord)) return 0;
			HashSet<String> beginSet = new HashSet<>();
			HashSet<String> endSet = new HashSet<>();
			beginSet.add(beginWord);
			endSet.add(endWord);
			int dis = 1;
			
			while(!beginSet.isEmpty() &&!endSet.isEmpty()){
				//to save time keep the beginset smaller one
				if(beginSet.size()>endSet.size()){
					HashSet<String> set = beginSet;
					beginSet = endSet;
					endSet = set;
				}
				
				HashSet<String> tempSet = new HashSet<>();
				for(String word: beginSet){
					char [] chrs = word.toCharArray();
					for(int i=0;i<chrs.length;i++){
						for(int j=0;j<26;j++){
							char old = chrs[i];
							chrs[i] = (char)('a'+j);
							String tempString = String.valueOf(chrs); 
							if(endSet.contains(tempString)) return dis+1;
							if(dic.contains(tempString)){
								dic.remove(tempString);
								tempSet.add(tempString);
							}
							chrs[i] = old;
						}
					}
				}
				
				beginSet = tempSet;
				dis++;
				
			}
			
			return 0;
	    }
	
		//two sides BFS
		public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		    //save wordList to dic
			HashSet<String> dic = new HashSet<>();
			for(String word:wordList){
				dic.add(word);
			}
			if(!dic.contains(endWord)) return 0;
			Queue<String> beginQueue = new LinkedList<>();
			Queue<String> endQueue = new LinkedList<>();
			
			int dist = 1;
			beginQueue.offer(beginWord);
			endQueue.offer(endWord);
			
			while(!beginQueue.isEmpty() && !endQueue.isEmpty()){
				//set the beginQueue smaller one to short the running time
				//System.out.println(Arrays.toString(beginQueue.toArray()));
				if(beginQueue.size()>endQueue.size()){
					Queue<String> temp = beginQueue;
					beginQueue = endQueue;
					endQueue = temp;
				}
				
				int level = beginQueue.size();
				for(int k=0;k<level;k++){
					String word = beginQueue.poll();
					wordList.remove(word);
					char [] chs = word.toCharArray();
					for(int i=0;i<word.length();i++){
						for(int j=0;j<26;j++){
							char old = chs[i];
							chs[i] = (char)('a'+j);
							String target = String.valueOf(chs);
							if(endQueue.contains(target)) return dist+1;
							if(dic.contains(target)){
								beginQueue.offer(target);
								dic.remove(target);
							}
							chs[i] = old;
						}
					}
				}
				
				dist++;
			}
			
			return 0;
		}
	
	//One way search solution, LTE
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
		//insert endWord to the end of wordList
		queue.offer(beginWord);
		int dis = 1;
		
		while(!queue.isEmpty()){
			int level = queue.size();
			System.out.println("Q:"+Arrays.toString(queue.toArray()));
			for(int k=0;k<level;k++){
				String word = queue.poll();
				wordList.remove(word);
				if(endWord.equals(word)) return dis;
				for(int i=0;i<word.length();i++){
					char [] temp = word.toCharArray();
					for(int j=0;j<26;j++){
						char old = word.charAt(i);
						temp[i] = (char)('a'+j);
						String target = String.valueOf(temp);
						if(wordList.contains(target)){
							queue.offer(String.valueOf(temp));
							wordList.remove(temp);
						}	
						temp[i] = old;
					}
				}
			}
			dis++;
		}
		
		return 0;
    }

}
