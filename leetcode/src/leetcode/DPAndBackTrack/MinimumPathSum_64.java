package leetcode.DPAndBackTrack;

public class MinimumPathSum_64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//dp
	public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        int [][] dp = new int [grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else if(i==0 && j!=0) dp[i][j] = dp[i][j-1]+grid[i][j];
                else if(i!=0 && j==0) dp[i][j] = dp[i-1][j]+grid[i][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }
}
