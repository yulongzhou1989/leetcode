package leetcode.dp;

import java.util.Arrays;

public class MaximumVacationDays_google_568 {

	public int maxVacationDays(int[][] flights, int[][] days) {
        if(days.length==0 || days[0].length==0) return 0;
        int m = days.length;//city number
		int n = days[0].length;//number of weeks
		
		int [][] dp = new int [n][m];
		int max = 0;
        
       for (int[] row : dp)
        Arrays.fill(row, -1);
        
		for(int j=0;j<m;j++){
			dp[0][j] = (flights[0][j] == 1 || j==0)? days[j][0]:-1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<m;k++){
					if(dp[i-1][k]!=-1 && (flights[k][j] == 1 || k==j))
						dp[i][j] = Math.max(dp[i-1][k] + days[j][i], dp[i][j]);
				}
                max = Math.max(dp[i][j], max);
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
		
		return max;
    }
}
