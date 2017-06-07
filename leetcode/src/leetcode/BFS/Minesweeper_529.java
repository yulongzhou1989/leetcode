package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper_529 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//DFS way
	public char[][] updateBoard1(char[][] board, int[] click) {
		if(board==null || board.length==0 || board[0].length==0) return board;
		//if die
		if(board[click[0]][click[1]] == 'M'){
			board[click[0]][click[1]] = 'X';
			return board;
		}
		
		//dfs
		dfs(board, click);
		
		return board;
    }
	
	private void dfs(char [][] board, int [] p){
		if(board[p[0]][p[1]]!='E') return;
		int numMine = checkMine(board, p);
		board[p[0]][p[1]] = numMine==0?'B':(char)('0'+numMine);
		if(numMine==0){
    		//search 8 directions
    		for(int i=0;i<8;i++){
    			int x = p[0] + dirs[i][0];
    			int y = p[1] + dirs[i][1];
    			if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y] == 'E'){
    				dfs(board, new int []{x,y});
    			}
    		}
		}
	}
	
	//BFS way
	final int [][] dirs = new int [][] {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	public char[][] updateBoard(char[][] board, int[] click) {
		if(board==null || board.length==0 || board[0].length==0) return board;
		//if die
		if(board[click[0]][click[1]] == 'M'){
			board[click[0]][click[1]] = 'X';
			return board;
		}
		
		//BFS
		Queue<int []> queue = new LinkedList<>();
		queue.offer(click);
		
		while(!queue.isEmpty()){
			int [] pos = queue.poll();
			int numMine = checkMine(board, pos);
			if(numMine == 0){
				board[pos[0]][pos[1]] = 'B';
				//search 4 directions
				for(int i=0;i<8;i++){
					int x = pos[0] + dirs[i][0];
					int y = pos[1] + dirs[i][1];
					if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]=='E'){
						board[x][y] = 'B';//avoid dulplicate
						queue.offer(new int []{x, y});
					}
				}
			} 
			else{
				board[pos[0]][pos[1]] = (char)('0' + numMine);
			} 
		}
		
		return board;
    }
	
	private int checkMine(char [][] board, int [] pos){
		int count = 0;
		for(int i=0;i<8;i++){
			int x = pos[0] + dirs[i][0];
			int y = pos[1] + dirs[i][1];
			
			if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]=='M'){
				count++;
			}
		}
		return count;
	}
}
