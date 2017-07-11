package leetcode.dp;

import java.util.Arrays;

public class RangeSumQueue2DImmutable_304 {
	public class NumMatrix {

	    int [][] sums;
	    public NumMatrix(int[][] matrix) {
	        if(matrix.length==0 || matrix[0].length==0) {
	            sums = new int [][] {};
	            return;
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        sums = new int [m][n];
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                sums[i][j] = (i>0?sums[i-1][j]:0) + (j>0?sums[i][j-1]:0) - ((i>0 && j>0)?sums[i-1][j-1]:0) + matrix[i][j];
	            }
	        }
	        System.out.println(Arrays.deepToString(sums));
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        if(row1<0 || col1<0 || row2>=sums.length || col2>=sums[0].length) return -1;
	        int res = sums[row2][col2] - (row1>0?sums[row1-1][col2]:0) - (col1>0?sums[row2][col1-1]:0) 
	            + (row1>0 && col1>0?sums[row1-1][col1-1]:0);
	        return res;
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */
}
