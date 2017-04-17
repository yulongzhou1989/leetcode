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
}
