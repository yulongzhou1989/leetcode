package contest;

public class ReshapeTheMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums==null || nums.length==0 || nums[0].length==0) return new int [][]{};
        
        int nr = nums.length;
        int nc = nums[0].length;
        
        if(nr*nc!=r*c) return nums;
        
        int [][] matrix = new int [r][c];
        int pos = 0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = nums[pos/nc][pos%nc];
                pos++;
            }
        }
        
        return matrix;
    }
}
