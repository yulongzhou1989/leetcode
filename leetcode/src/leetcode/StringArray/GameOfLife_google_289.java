package leetcode.StringArray;

import java.util.Arrays;

public class GameOfLife_google_289 {
	
	public static void main (String [] args){
		//int [][] board = new int [][] {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
		//[[0,0,0,0,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,0,0,0]]
		int [][] board = new int [][] {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
		gameOfLife(board);
	}

	public static void gameOfLife(int[][] board) {
		//Copy array!! do not use the reference!
        int [][] preStatus = new int [board.length][];
        for (int i=0;i<board.length;i++){
        	preStatus[i] = Arrays.copyOf(board[i], board[i].length);
        }
        
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int count = 0;
                if (i>0 && preStatus[i-1][j] == 1)
                    count++;
                if (i<board.length-1 && preStatus[i+1][j] == 1)
                    count++;
                if (j>0 && preStatus[i][j-1] == 1)
                    count++;
                if (j<board[0].length-1 && preStatus[i][j+1] == 1)
                    count++;
                if (i>0 && j>0 && preStatus[i-1][j-1] == 1)
                    count++;
                if (i<board.length-1 && j<board[0].length-1 && preStatus[i+1][j+1] == 1)
                    count++;
                if (j>0 && i<board.length-1 && preStatus[i+1][j-1] == 1)
                    count++;
                if (j<board[0].length-1 && i>0 && preStatus[i-1][j+1] == 1)
                    count++;
                if (count<2 || count>3) board[i][j] = 0;
                else if (count ==3) board[i][j] = 1;
            }
        }
    }
}


