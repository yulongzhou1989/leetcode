package leetcode.DPAndBackTrack.BSF_DFS;

public class WordSearch_79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char [][] {{'A','B','C','E'},{'S','F','E','K'},{'A','D','E','E'}};
		System.out.println(exist(board,"ABCEFSADEEKE"));
	}

	static int m;
	static int n;
	static int [] dirs = new int [] {0,1,0,-1,0};
	
	public static boolean exist(char[][] board, String word) {
		if(board==null || board.length==0 || board[0].length==0) return false;
		m=board.length;
		n=board[0].length;
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//if start letter is current char
				if(word.charAt(0)==board[i][j]){
					if(dfs(board, word, new boolean [m][n], 0, i, j)) return true;
				}
			}
		}
		
		return false;
    }
	
	private static boolean dfs(char [][] board, String word, boolean [][] visited, int pos, int r, int c){
		if(word.charAt(pos) == 'K'){
			System.out.println("K");
		}
		System.out.println(pos + " " + board[r][c]);
		if(board[r][c]!=word.charAt(pos)) return false;
		if(board[r][c]==word.charAt(pos) && pos==word.length()-1) return true;
		visited[r][c] = true;
		
		//search 4 directions
		for(int i=0;i<4;i++){
			int newR = r+dirs[i];
			int newC = c+dirs[i+1];
			//in boundary or not visited before
			if(newR>=0 && newR<m && newC>=0 && newC<n && !visited[newR][newC]) {
				if(dfs(board, word, visited, pos+1, newR, newC)) return true;
			}
		}
		visited[r][c] = false;
		return false;
	}
}
