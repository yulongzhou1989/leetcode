package leetcode.search;

public class SearchA2DMatrixII_google_240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
		int m=matrix.length, n=matrix[0].length;
		//if target is bigger than left bottom and smaller than right top, return false;
		if(matrix[0][0]>target || matrix[m-1][n-1]<target) return false;
		int row=0, col=n-1;
		//f the target is less than the value in current position,
		//then the target can not in the entire column because the column is sorted too. 
		while(col>=0 && row<m){
			//if target 
			if(matrix[row][col]==target) return true;
			else if(matrix[row][col]>target) col--;
			else if(matrix[row][col]<target) row++;
		}
		
		return false;
    }

}
