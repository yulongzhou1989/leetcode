package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPath_google_656 {
	public List<Integer> cheapestJump(int[] A, int B) {
		List<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0 || B == 0 || A[0] == -1) return res;
		int n = A.length;
		int [] trace = new int [n];
		long [] dp = new long [n];
		//initial trace
		Arrays.fill(trace, -1);

        for(int i = n - 2; i >= 0; i--){
            dp [i] = Integer.MAX_VALUE; 
            if(A[i] == -1) continue;
            for(int j = i + 1; j <= B + i && j < n; j++) {
                if(A[i] != -1 && dp[j] + A[i] < dp[i]){
                    dp[i] = dp[j] + A[i];
                    trace[i] = j;
                }
            }
        }
        
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(trace));
		
        int i = 0;
		for (; i < A.length && trace[i] > 0; i = trace[i])
            res.add(i + 1);
        if (i == A.length - 1 && A[i] >= 0)
            res.add(A.length);
        else
            return new ArrayList <Integer> ();
        
        return res;
    }
}
