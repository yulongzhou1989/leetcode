package leetcode.design.objects;

public class TicTacToe {
	
	//save map
    int [][] map;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.map = new int [n][n]; 
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        map[row][col] = player;
        if(win(row, col, player)) 
            return player;
        else 
            return 0;
    }
    
    boolean win(int row, int col, int player){
        int count1=0, count2=0, count3=0,count4=0, n=map.length;
        for (int i=0;i<n;i++){
            //check \ cross
            if(row == col && map[i][i] == player)
                count1++;
            //check / cross
            if(row == n-col-1 && map[i][n-i-1] == player)
                count2++;
            //check vertical
            if (map[row][i] == player)
                count3++;
            //check horizonal
            if (map[i][col] == player)
                count4++;
        }
        
        return (count1==n || count2==n || count3==n || count4==n);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */