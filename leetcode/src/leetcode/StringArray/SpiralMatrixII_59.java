package leetcode.StringArray;

public class SpiralMatrixII_59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] generateMatrix(int n) {
        if(n==0) return new int [][]{};
		int [][] matrix = new int [n][n];
		int rowStart=0, rowEnd=n-1, colStart=0, colEnd=n-1, pos=1;
		
		while(rowStart<=rowEnd && colStart<=colEnd){
			//fill right
			for(int i=colStart;i<=colEnd;i++){
				matrix[rowStart][i] = pos++;
			}
			rowStart++;
			//fill down
			for(int i=rowStart;i<=rowEnd;i++){
				matrix[i][colEnd] = pos++;
			}
			colEnd--;
			//fill left
			for(int i=colEnd;i>=colStart;i--){
				matrix[rowEnd][i] = pos++;
			}
			rowEnd--;
			//fill up
			for(int i=rowEnd; i>=rowStart;i--){
				matrix[i][colStart] = pos++;
			}
			colStart++;
		}
		
		return matrix;
    }
}
