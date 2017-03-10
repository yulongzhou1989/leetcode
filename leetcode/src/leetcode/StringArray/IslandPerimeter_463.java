package leetcode.StringArray;

public class IslandPerimeter_463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int premeter = 0;
        
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                //if island, judge upper, left, right, down
                if(grid[i][j] == 1){
                    if(i==0 || grid[i-1][j] == 0) premeter ++;
                    if(i==grid.length-1 || grid[i+1][j] == 0) premeter ++;
                    if(j==0 || grid[i][j-1] == 0) premeter ++;
                    if(j==grid[0].length-1 || grid[i][j+1] == 0) premeter ++;
                }        
            }
        }
        
        return premeter;
    }
}
