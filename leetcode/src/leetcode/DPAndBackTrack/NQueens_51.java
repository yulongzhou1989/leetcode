package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
		char [][] nQueens = new char [n][n];
		//initial board
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				nQueens[i][j] = '.';
			}
		}
		helper(res, n, 0, nQueens);
		return res;
    }
	
	private void helper(List<List<String>> res, int n, int row, char [][] nQueens){
		if(row==n){
			res.add(arrayToList(nQueens));
			return;
		}
		for(int col=0;col<n;col++){
			if(isValid(nQueens, row, col, n)){
			    //System.out.println("row:"+row+",col:"+col);
				nQueens[row][col] = 'Q';
				helper(res,n,row+1,nQueens);
				nQueens[row][col] = '.';
			}
		}
	}
	
	private boolean isValid(char [][] nQueens, int row, int col, int n){
		//check col has queen
		for(int i=0;i!=row;i++){
			if(nQueens[i][col] == 'Q') return false;
		}
		//diagonal
		for(int i=row-1, j=col-1;i>=0 &&j>=0;i--,j--){
			if(nQueens[i][j] == 'Q') return false;
		}
		//check another diagonal
		for(int i=row-1, j=col+1;i>=0 && j<n; i--,j++){
			if(nQueens[i][j] == 'Q') return false;
		}
		return true;
	}
	
	private List<String> arrayToList(char [][] arr){
		List<String> list = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<arr[0].length;j++){
				sb.append(arr[i][j]);
			}
			list.add(sb.toString());
		}
		return list;
	}
}
