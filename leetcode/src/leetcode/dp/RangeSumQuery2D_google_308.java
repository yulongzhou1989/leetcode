package leetcode.dp;

public class RangeSumQuery2D_google_308 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class NumMatrix {

	    int [][] m;
	    //save sum to rowIndex;
	    int [][] rowVals;

	    public NumMatrix(int[][] matrix) {
	        if(matrix.length<=0) return;
	        m = matrix;
	        rowVals = new int [matrix.length][matrix[0].length];
	        for(int i=0;i<matrix.length;i++){
	            int rowVal=0;
	            for(int j=0;j<matrix[0].length;j++){
	                rowVal += matrix[i][j];
	                rowVals [i][j] = rowVal;
	            }
	        }
	    }
	    
	    public void update(int row, int col, int val) {
	        for(int j=col;j<m[0].length;j++){
	            rowVals[row][j] += val-m[row][col];
	        }
	        m[row][col] = val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int sum = 0;
	        for(int i=row1;i<=row2;i++){
	            sum += rowVals[i][col2]-(col1==0?0:rowVals[i][col1-1]);
	        }
	        return sum;
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * obj.update(row,col,val);
	 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
	 */

	public class NumMatrix1 {

	    private int[][] colSums;
	    private int[][] matrix;
	    
	    public NumMatrix1(int[][] matrix) {
	        if(   matrix           == null
	           || matrix.length    == 0
	           || matrix[0].length == 0   ){
	            return;   
	         }
	         
	         this.matrix = matrix;
	         
	         int m   = matrix.length;
	         int n   = matrix[0].length;
	         colSums = new int[m + 1][n];
	         for(int i = 1; i <= m; i++){
	             for(int j = 0; j < n; j++){
	                 colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
	             }
	         }
	    }
	    //time complexity for the worst case scenario: O(m)
	    public void update(int row, int col, int val) {
	        for(int i = row + 1; i < colSums.length; i++){
	            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
	        }
	        
	        matrix[row][col] = val;
	    }
	    //time complexity for the worst case scenario: O(n)
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int ret = 0;
	        
	        for(int j = col1; j <= col2; j++){
	            ret += colSums[row2 + 1][j] - colSums[row1][j];
	        }
	        
	        return ret;
	    }
	}
}
