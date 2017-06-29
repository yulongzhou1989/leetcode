package leetcode.dp;

public class CopyBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Undone
	public int copyBooks(int[] pages, int k) {
        //dp[k][i] = min(dp[k][i],max(dp[k-1][j], SUM(j->i-1)))
		if(pages.length==0) return 0;
		int n = pages.length;
		if(k>n) k = n;
		int [][] dp = new int [k+1][n+1];
		for(int m = 1;m<=k;m++){
			for(int i = 1;i<=n;i++){
				int sum = 0;
				//cal sum from 0->i
				for(int l = 0; l<i;l++){
					sum+=pages[l];
				}
				dp[m][i] = Integer.MAX_VALUE;
				for(int j = 0; j<i;j++){
					dp[m][i] = Math.min(dp[m][i], Math.max(dp[m-1][j], sum));
		            System.out.println("dp[m][i]:" + dp[m][i] + ",sum:" + sum 
		            +",i:" + i +",m:" +m);
					sum-=pages[j];
				}
			}
		}
		
		return dp[k][n];
    }
}
