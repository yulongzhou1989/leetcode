package leetcode.trietree;

public class Trie {

    public class TrieNode{
		TrieNode [] children;
		boolean isWord;
		Character c;
		
		public TrieNode() {
			children = new TrieNode [26];
			isWord = false;
			c = null;
		}
		
		public TrieNode(Character c){
			children = new TrieNode [26];
			isWord = false;
			this.c = c;
		}
	}
	
	TrieNode root;
	
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null || word.length()==0) return;
		TrieNode node = root;
		//insert word into trietree
		for(int i=0;i<word.length();i++){
			Character c = word.charAt(i);
			if(node.children[c-'a'] == null) 
				node.children[c-'a'] = new TrieNode(c);
			node = node.children[c-'a'];
		}
		node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchTrieNode(root, word);
		return node==null?false:node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
		TrieNode node = searchTrieNode(root, prefix);
		return node==null?false:true;
    }
	
	/** search the last children node for the searched word */
	private TrieNode searchTrieNode(TrieNode root, String word){
		TrieNode node = root;
		for(int i=0; i<word.length();i++){
			Character c = word.charAt(i);
			if(node.children[c-'a']==null) return null;
			node = node.children[c-'a'];
		}
		return node;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */