package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain_646 {
	public int findLongestChain(int[][] pairs) {
        if(pairs==null || pairs.length==0) return 0;
        
        //dp[i] = max(1, dp[j]+1| if can match)
        int n = pairs.length;
        int [] dp = new int [n];
        Arrays.sort(pairs, new Comparator<int []>(){
            @Override
            public int compare(int [] a, int b []){
                if(a[0]==b[0]) return b[1] - a[1];
                else return a[0]-b[0];
            }
        });
        int max = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        
        return max;
    }
}
