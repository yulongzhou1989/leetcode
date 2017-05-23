package leetcode.design.objects;


public class WordDictionary {

	public class TrieNode{
		public char var;
		public boolean isWord;
		public TrieNode [] children = new TrieNode[26];
		public TrieNode(){}
		public TrieNode(char c){
			this.var = c;
		}
	}

	TrieNode root;
	
    /** Initialize your data structure here. */
    public WordDictionary() {
		root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode n = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(n.children[c-'a'] == null) 
				n.children[c-'a'] = new TrieNode(c);
			n = n.children[c-'a'];
		}
		n.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }
	
	public boolean search(String word, TrieNode node){
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(c=='.') {
				for(TrieNode nc:node.children){
					if(nc!=null && search(word.substring(i+1), nc)) return true;
				}
				return false;
			} else{
				if(node.children[c-'a']==null) return false;
				else{
					node = node.children[c-'a'];
				}
			}
		}
		return node.isWord;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
* Your WordDictionary object will be instantiated and called as such:
* WordDictionary obj = new WordDictionary();
* obj.addWord(word);
* boolean param_2 = obj.search(word);
*/
