package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurrondedRegions_130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int [] dirs = new int [] {0,1,0,-1,0};
	
	//BFS way, search from the boarder to inside
	public void solve(char[][] board) {
		if(board==null || board.length==0 || board[0].length==0) return;
		int height = board.length;
		int width = board[0].length;
		Queue<int []> queue = new LinkedList<>();
		//initial horizontal
		for(int i=0, j=height-1;i<width;i++){
			if(board[0][i]=='O') 
				queue.offer(new int [] {0, i});
			if((height-1)!=0 && board[j][i] == 'O')
				queue.offer(new int [] {j, i});
		}
		//initial vertical
		for(int i=0, j=width-1; i<height;i++){
			if(board[i][0] == 'O')
				queue.offer(new int [] {i, 0});
			if((width-1)!=0 && board[i][j] == 'O')
				queue.offer(new int [] {i, j});
		}
		//dfs board and set dummy value
		dfs(queue, board);
		//go over the matrix again and reset the dummy value
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				if(board[i][j] == 'O') board[i][j] = 'X';
				else if(board[i][j] == 'K') board[i][j] = 'O';
			}
		}
    }
	
	public void dfs(Queue<int []> q, char[][] board){
		
		while(!q.isEmpty()){
			int [] pos = q.poll();
			int i = pos[0];
			int j = pos[1];
			board[i][j] = 'K';
			//search 4 directions
			for(int k=0;k<4;k++){
				int x = i+dirs[k];
				int y = j+dirs[k+1];
				if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y] == 'O'){
					q.offer(new int []{x, y});
				}
			}
		}
	}
}
