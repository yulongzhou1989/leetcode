package leetcode.trietree;

import java.util.ArrayList;
import java.util.List;

public class MinimumUniqueWordAbbreviation_google_411 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minAbbreviation(String target, String[] dictionary) {
        
		Trie trie = new Trie();
		
		//save the dic to Trie
		for(int i=0;i<dictionary.length;i++){
			trie.insert(dictionary[i]);
		}
			
		//check each abbr
		for(int i=0;i<target.length();i++){
			//dfs get all abbrs
			List<String> abbrs = new ArrayList<>();
			getAbbre(abbrs, target, 0, 0, "", i+1);
			for(String abbr:abbrs){
				if(!trie.isAbbr(trie.root, abbr, 0)) return abbr;
			}
		}
	
		return "";
    }
	
	//use dfs get abrs in certain length
	public void getAbbre(List<String> abbrs, String target, int abbCount, int pos, String cur, int len){
		if(pos==target.length()){
			if(abbCount>0 && len==1) abbrs.add(cur+abbCount);
			if(abbCount==0&& len==0) abbrs.add(cur);
		}
		else{
			getAbbre(abbrs, target, abbCount+1, pos+1, cur, len);// abbreviate current pos
			getAbbre(abbrs, target, 0, pos+1, cur+(abbCount==0?"":abbCount+"")+target.charAt(pos), abbCount==0?len-1:len-2);// not abbreviate current pos		
		}
	}
	
	class TrieNode{
		
		public char val;
		public TrieNode [] children = new TrieNode[26];
		public boolean isWord;
		
		public TrieNode(){}
		
		public TrieNode(char c){
			this.val = c;
		}
	}
	
	class Trie{
		
		TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		public void insert(String word){
			
			TrieNode n = root;
			
			for(int i=0;i<word.length();i++){
				char c = word.charAt(i);
				if(n.children[c-'a']==null){
					n.children[c-'a'] = new TrieNode(c); 
				}
				n = n.children[c-'a'];
			}
			
			n.isWord = true;
		}
		
		public boolean isAbbr(TrieNode n, String abbr, int num){
		    if(n==null) return false;
			if(num>0) {// number of '*'
				for(TrieNode nc : n.children){
					if(nc!=null && isAbbr(nc, abbr, num-1)) return true;
				}
				return false;
			} else{
				if(abbr.length()==0) return n.isWord;
				int aNum=0;
				int i = 0;
				//if digit, get abbr deepth
				while(i<abbr.length() && abbr.charAt(i)>='0' && abbr.charAt(i)<='9'){
					aNum=aNum*10 + (abbr.charAt(i++)-'0');
				}
				if(aNum>0) return isAbbr(n, abbr.substring(i), aNum);//start with number
				else{
					if(n.children[abbr.charAt(0)-'a']==null) return false;
					else{
						return isAbbr(n.children[abbr.charAt(0)-'a'], abbr.substring(1), 0);
					}
				}				
			}
		}
	}

}
