package leetcode.trietree;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords_472 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
		for(int i=0;i<words.length;i++){
			trie.insert(words[i]);
		}
		List<String> res = new ArrayList<>();
		for(int i=0;i<words.length;i++){
			if(trie.isConcatenated(words[i], 0))
				res.add(words[i]);
		}
		return res;
    }
	
	public class TrieNode{
		public char val;
		public boolean isWord;
		public TrieNode [] children = new TrieNode [26];
		public TrieNode(){
			
		}
		public TrieNode(char c){
			this.val = c;
		}
	}
	
	public class Trie{
		
		TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		public void insert(String word){
			TrieNode tn = root;
			for(int i=0;i<word.length();i++){
				char c = word.charAt(i);
				if(tn.children[c-'a']==null)
					tn.children[c-'a'] = new TrieNode(c);
				tn = tn.children[c-'a'];
			}
			tn.isWord = true;
		}
		
		//use dfs way
		public boolean isConcatenated(String w, int counter){
			if(w.length()==0 && counter>1) return counter>1;
			TrieNode node = root;
			for(int i=0;i<w.length();i++){
				char c = w.charAt(i);
				TrieNode tn = node.children[c-'a'];
				if(tn==null) return false;
				else{
					if(tn.isWord) {
						if(isConcatenated(w.substring(i+1), counter+1)) return true;
					}
					node = tn;
				}
			}
			return false;
		}
	}
}
