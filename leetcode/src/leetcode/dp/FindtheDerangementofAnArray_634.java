package leetcode.dp;

public class FindtheDerangementofAnArray_634 {


	public int findDerangement(int n) {
        if(n<2) return 0;
        
        long [] dp = new long [n+1];
        dp[2] = 1;
        dp[1] = 0;
        for(int i=3;i<=n;i++){
            dp[i] = ((i-1)*(dp[i-1]+dp[i-2]))%1000000007;
        }
        
        return (int)dp[n];
    }
}
