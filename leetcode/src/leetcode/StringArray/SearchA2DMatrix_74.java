package leetcode.StringArray;

public class SearchA2DMatrix_74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int [][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		//int [][] arr = new int [][] {{}};
		System.out.println(searchMatrix(arr, 50));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
		int m=matrix.length, n=matrix[0].length;
		//if target is bigger than left bottom and smaller than right top, return false;
		if(matrix[0][0]>target || matrix[m-1][n-1]<target) return false;
		int row=0, col=n-1;
		int start = 0, end = m;
		//find which row
		while(start<=end){
			row = (start+end)/2;
			//if target 
			if(matrix[row][col]==target) return true;
			if(matrix[row][col]>target) end = row-1;
			if(matrix[row][col]<target) start = row+1;
		}
		//find which col of that row
		row=start;
		start = 0;
		end = n; 
		while(start<=end){
			col = (start+end)/2;
			//if target 
			if(matrix[row][col]==target) return true;
			if(matrix[row][col]>target) end = col-1;
			if(matrix[row][col]<target) start = col+1;
		}
		return false;
    }
	
	//take it as a linklist
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m=matrix.length, n=matrix[0].length;
        int l=0, h=m*n-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(matrix[mid/n][mid%n]==target) return true;
			else if(matrix[mid/n][mid%n]<target) l = mid+1;
			else h = mid-1;
        }
		
		return false;
    }
}
