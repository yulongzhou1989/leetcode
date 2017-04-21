package leetcode.DPAndBackTrack;

public class UniqueBinarySearchTrees_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTrees(int n) {
		// f(n) = f(0,n)+....+f(n,n) i is root
		// f(i,n) = f(i-1)*f(n-i) eg. 3, 7 (1,2) (4..7)
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
}
