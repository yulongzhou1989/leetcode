package leetcode.dp;

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxCoins(int[] ns) {
        if(ns.length==0) return 0;
		//eliminate zero balloons
		int [] nums = new int [ns.length+2];
		int n=1;
		for(int i:ns){
			if(i!=0) nums[n++]=i;
		}
		nums[0] = 1;
		nums[n++] = 1;
		int [][] dp = new int [n][n];
        //C(n,k) range to burst balloons
		for(int k=2;k<n;k++){
			for(int left=0;left<n-k;left++){
				int right = left+k;
				for(int i=left+1;i<right;i++){
					//seperate the array into 3 parts, right , left and burst collection
					dp[left][right] = Math.max(dp[left][right], nums[left]*nums[i]*nums[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		
		return dp[0][n-1];
    }

}
