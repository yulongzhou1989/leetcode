package leetcode.DPAndBackTrack;

public class NQueensII_52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int total = 0;
	public int totalNQueens(int n) {
		if(n<2) return n;
		
		char [][] nQueue = new char [n][n];
		for(int i=0;i<nQueue.length;i++){
			for(int j=0;j<nQueue[0].length;j++){
				nQueue[i][j] = '.';
			}
		}
		
		getNQueens(nQueue, n, 0);
		return total;
    }
	
	private void getNQueens(char [][] nQueue, int n, int row){
		if(row == n) total++;
		
		for(int col=0; col<n;col++){
			if(isValid(nQueue, row, col, n)){
				nQueue[row][col] = 'Q';
				getNQueens(nQueue,n, row+1);
				nQueue[row][col] = '.';
			}
		}
	}
	
	private boolean isValid(char [][] nQueue, int row, int col, int n){
		//check vertical
		for(int i=0;i!=row;i++){
			if(nQueue[i][col]=='Q') return false;
		}
		//check diagonal
		for(int i=row-1, j=col-1;i>=0 && j>=0; i--,j--){
			if(nQueue[i][j]=='Q') return false;
		}
		//check the other diagonal
		for(int i=row-1, j=col+1;i>=0 && j<n; i--, j++){
			if(nQueue[i][j]=='Q') return false;
		}
		
		return true;
	}

}
