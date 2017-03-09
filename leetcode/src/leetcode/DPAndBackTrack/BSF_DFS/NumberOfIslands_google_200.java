package leetcode.DPAndBackTrack.BSF_DFS;

public class NumberOfIslands_google_200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (grid[i][j] == '1'){
                    markGrid(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    void markGrid(char [][] grid, int i, int j){
        //reach boundray or is not island
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') return;
        grid[i][j] = '0';
        markGrid(grid,i-1,j);
        markGrid(grid,i+1,j);
        markGrid(grid,i,j-1);
        markGrid(grid,i,j+1);
    }

}
