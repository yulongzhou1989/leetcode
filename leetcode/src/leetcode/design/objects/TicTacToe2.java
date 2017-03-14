package leetcode.design.objects;

public class TicTacToe2 {
	
	private int [] rows;
	private int [] cols;
	private int diagonal;
	private int antidiagonal;
	
	public TicTacToe2(int n){
		rows = new int [n];
		cols = new int [n];
		diagonal = 0;
		antidiagonal = 0;
	}
	
	public int move(int row, int col, int player){
		int toAdd = player==1?1:-1;
		rows[row] += toAdd;
		cols[col] += toAdd;
		if (row == col) diagonal += toAdd;
		int n = rows.length;
		if (row == n-col-1) antidiagonal += toAdd;
		if (Math.abs(rows[row]) == n || Math.abs(cols[col])==n 
		 || Math.abs(diagonal)==n || Math.abs(antidiagonal) == n) return player;
		else return 0;
	}
	
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */