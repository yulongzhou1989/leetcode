package leetcode.trietree;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_google_212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int [] dirs = new int [] {0,1,0,-1,0};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
          for(int j=0;j<board[0].length;j++){
            getList(i, j, board, trie.root, list, new boolean [board.length][board[0].length]);
          }
        }
        
        return list;
    }

    //dfs
    public void getList(int i, int j, char[][] board, TrieNode node, List<String> list, boolean [][] visited){
        TrieNode tn = node.children[board[i][j]-'a'];
        if(visited[i][j] || tn==null) return;
        if(tn.isWord){
            if(!list.contains(tn.word))
                list.add(tn.word);
        }
        visited[i][j] = true;
        //search 4 directions
        for(int k=0;k<4;k++){
          int x = i+dirs[k];
          int y = j+dirs[k+1];
          if(x>=0 && y>=0 && x<board.length && y<board[0].length && !visited[x][y]){
            getList(x, y, board, tn, list, visited);
          }
        }
        visited[i][j] = false;
    }

    public class TrieNode {
        public char val;
        public boolean isWord;
        public String word;
        public TrieNode [] children = new TrieNode[26];
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
            TrieNode n = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(n.children[c-'a']==null)
                    n.children[c-'a'] = new TrieNode(c);
                n = n.children[c-'a'];
            }
            n.isWord = true;
            n.word = word;
        }
    }
}
