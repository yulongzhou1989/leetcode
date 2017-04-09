package leetcode.DPAndBackTrack;

public class UniquePaths_62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(uniquePaths(1,2));
	}

	public static int uniquePaths(int m, int n) {
        //f(m,n) = f(m-1,n)+f(m,n-1)+1;
        int [][] dp = new int [m][n];
        dp[0][0] = 1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 || j!=0) {
                    dp[i][j] = (i>0?dp[i-1][j]:0)+(j>0?dp[i][j-1]:0);
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
