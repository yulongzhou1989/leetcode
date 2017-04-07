package leetcode.StringArray;

public class DiagonalTraverse_google_498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return new int [] {};
        int m=matrix.length, n=matrix[0].length;
		int [] res = new int [m*n];
		int row=0, col=0, d=0;
		int [][] dir = new int [][] {{-1,1},{1,-1}};
		for(int i=0;i<m*n;i++){
			res[i] = matrix[row][col];
			row = row+dir[d][0];
			col = col+dir[d][1];
			
			/*
				####
				####
				####
			   #->(col=col+2)
			*/
			if(row>=m) {row=m-1; col=col+2;d=1-d;}
			if(col>=n) {col=n-1; row=row+2;d=1-d;}
			if(row<0){row=0;d=1-d;}
			if(col<0){col=0;d=1-d;}
		}
		
		return res;
    }

}
