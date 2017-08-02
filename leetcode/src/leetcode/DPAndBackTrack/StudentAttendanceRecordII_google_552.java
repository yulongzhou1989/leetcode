package leetcode.DPAndBackTrack;

public class StudentAttendanceRecordII_google_552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static final int M = 1000000007;
	public int checkRecord(int n) {
        //use matrix save records

		int [][][] dp = new int [n+1][2][3];
		//initial dp 

		dp[0] = new int [][] {{1,1,1},{1,1,1}};
		//use j-- numbers of A, k--- numbers of L
		for(int i=1;i<=n;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<3;k++){
					//dp [n][i][j] = dp[n-1][i][2]+dp[n-1][j-1][2]+dp[n-1][j][k-1];
					int val = dp[i-1][j][2];// P
					if(j>0) val = (val+dp[i-1][j-1][2])%M;//A
					if(k>0) val = (val+dp[i-1][j][k-1])%M;//L
					dp[i][j][k] = val;
				}
			}
		}
		
		return dp[n][1][2];
    }
	
	
	public int checkRecord1(int n) {
		long [][] dp = new long [n+1][2];
		
		dp[0][1] = dp[0][0] = 1;//空is also a possiblity
		dp[1][1] = 2;
        dp[1][0] = 1;
		
		for(int i = 2; i <= n; i++){
			dp[i][0] = dp[i-1][1];//end with P
            // end with P + end with L
            dp[i][1] = (dp[i][0] + dp[i-1][0] + dp[i-2][0])%M;
		}
        
        //insert A
        long res = dp[n][1];//initial with without A
        //insert A, before A part, 全排列， after A 全排列
		for(int i=0;i<n;i++){
			long withA = (dp[i][1] * dp[n-i-1][1])%M;
			res = (res+withA)%M;
		}
        
        return (int) res;
    }
}
