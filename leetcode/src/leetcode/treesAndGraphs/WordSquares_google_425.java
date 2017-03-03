package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class WordSquares_google_425 {
	public static void main (String [] args){
		String [] s = {"area","lead","wall","lady","ball"};
		System.out.println(wordSquares(s));
	}
	
	
	
	public static List<List<String>> wordSquares(String [] words){
		List<List<String>> ans = new ArrayList<>();
		if (words == null || words.length == 0){
			return ans;
		}
		int length = words[0].length();
		Trie trie = new Trie(words);
		List<String> ansBuilder = new ArrayList<>();
		for (String w: words){
			ansBuilder.add(w);
			search(length, trie, ans, ansBuilder);
			ansBuilder.remove(ansBuilder.size()-1);
		}
		
		return ans;
	}
	
	private static void search(int len, Trie tr, List<List<String>> ans, List<String> ansBuilder){
		if (ansBuilder.size() == len){
			ans.add(new ArrayList<>(ansBuilder));
			return;
		}
		
		int idx = ansBuilder.size();
		StringBuilder prefixBuilder = new StringBuilder();
		for (String s: ansBuilder){
			prefixBuilder.append(s.charAt(idx));
		}
		List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
		for (String sw:startWith){
			ansBuilder.add(sw);
			search(len, tr, ans, ansBuilder);
			ansBuilder.remove(ansBuilder.size()-1);
		}
	}
}

class TrieNode {
	List<String> startWith;
	TrieNode [] children;
	
	TrieNode() {
		startWith = new ArrayList<>();
		children = new TrieNode[26];
	}
}

class Trie {
	TrieNode root;
	
	Trie(String [] words){
		root = new TrieNode();
		for (String w: words){
			TrieNode cur = root;
			for (char ch: w.toCharArray()){
				int idx = ch - 'a';
				if (cur.children[idx] == null)
					cur.children[idx] = new TrieNode();
				cur.children[idx].startWith.add(w);
				cur = cur.children[idx];
			}
		}
	}
	
	List<String> findByPrefix(String prefix){
		List<String> ans = new ArrayList<>();
		TrieNode cur = root;
		for (char ch: prefix.toCharArray()){
			int idx = ch-'a';
			if(cur.children[idx] == null)
				return ans;
			cur = cur.children[idx];
		}
		ans.addAll(cur.startWith);
		return ans;
	}
}
