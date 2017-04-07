package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_google_54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//On*m space
	public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;
		//count visited node
		int count = 0, d=0;
		int m=matrix.length, n=matrix[0].length;
		int [] dirs = {0,1,0,-1,0};
		boolean [][] visited = new boolean [m][n];
		for(int i=0,j=0;count<m*n;i+=dirs[d],j+=dirs[d+1], count++){
			res.add(matrix[i][j]);
			visited[i][j] = true;
			//if next visit will hit the wall or already visited point, change direction
			if(i+dirs[d]>=m || i+dirs[d]<0 || j+dirs[d+1]>=n || j+dirs[d+1]<0 || visited[i+dirs[d]][j+dirs[d+1]]) 
				d = (d+1)%4;
		}
		
		return res;
    }
	
	//o1 space
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;

		int m=matrix.length, n=matrix[0].length;
		int rowBegin=0, colBegin=0, rowEnd=m-1, colEnd=n-1;

		while(rowBegin<=rowEnd && colBegin<=colEnd){
			//go right
			for(int j=colBegin;j<=colEnd;j++){
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;
			//go down
			for(int i=rowBegin;i<=rowEnd;i++){
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			//go left
			for(int j=colEnd; j>=colBegin && rowBegin<=rowEnd; j--){
				res.add(matrix[rowEnd][j]);
			}
			rowEnd--;
			//go up
			for(int i=rowEnd; i>=rowBegin && colBegin<=colEnd; i--){
				res.add(matrix[i][colBegin]);
			}
			colBegin++;
		}
		
		return res;
    }
}
