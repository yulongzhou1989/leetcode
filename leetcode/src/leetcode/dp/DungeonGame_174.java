package leetcode.dp;

import java.util.Arrays;

public class DungeonGame_174 {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
		int m = dungeon.length;
		int n = dungeon[0].length;
        int [][] dp = new int [m+1][n+1];//dp[i][j] = min(dp[m-1][n], dp[m][n-1])- A[i][j] | need>0, else 1
		
        for(int [] a:dp){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        
		dp[m-1][n] = dp[m][n-1] = 1;
		
		for(int i = m-1; i>=0; i--){
			for(int j=n-1; j>=0; j--){
				int need = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];
                //System.out.println(need);
				dp[i][j] = need<=0?1:need;
			}
		}
		
		return dp[0][0];
    }
}
