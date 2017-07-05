package leetcode.dp;

import java.util.List;

public class Triangle_120 {
	
	//On space
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0).size()==0) return 0;
		int n = triangle.size();
		int [][] dp = new int [n][n];// dp[i][j] = min(dp[i-1][j-1],dp[i-1, j]) + t[i][j]
		dp[0][0] = triangle.get(0).get(0);
        if(n==1) return dp[0][0];
		int res = Integer.MAX_VALUE;
		int cur = 1, pre = 0;
		for(int i=1;i<n;i++){
			for(int j=0;j<=i;j++){
				if(j==0) {
					dp[cur][j] = dp[pre][j]+triangle.get(i).get(j);
				}else if(j==i){
					dp[cur][j] = dp[pre][j-1]+triangle.get(i).get(j);
				}
				else{
					dp[cur][j] = Math.min(dp[pre][j-1], dp[pre][j]) + triangle.get(i).get(j);
				}
				//last row, compare result
                if(i==n-1){
                    res = Math.min(dp[cur][j], res);
                }
			}
			pre = cur;
			cur = 1-pre;
		}
		
		return res;
    }
	
	//On*n space
	public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0).size()==0) return 0;
		int n = triangle.size();
		int [][] dp = new int [n][n];// dp[i][j] = min(dp[i-1][j-1],dp[i-1, j]) + t[i][j]
		dp[0][0] = triangle.get(0).get(0);
        if(n==1) return dp[0][0];
		int res = Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
			for(int j=0;j<=i;j++){
				if(j==0) {
					dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
				}else if(j==i){
					dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
				}
                //last row, compare result
                if(i==n-1){
                    res = Math.min(dp[i][j], res);
                }
			}
		}
		
		return res;
    }
}
