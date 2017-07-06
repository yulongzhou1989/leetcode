package leetcode.dp;

public class LongestValidParenthese_32 {
	
	public int longestValidParentheses(String s) {
		if(s==null || s.length()<2) return 0;
		int n = s.length();
		int [] dp = new int [n];//dp[i] end with i longestValidParentheses, with means i is part of the validatParenthese
		
        int res = 0;
		for(int i=1;i<n;i++){
            if(s.charAt(i) == ')'){
				if(s.charAt(i-1)=='(') {
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }
				else{
					int preIndex = i-dp[i-1]-1;
					if(preIndex>=0 && s.charAt(preIndex) == '('){
						dp[i] = dp[i-1]+2+(preIndex>=1?dp[preIndex-1]:0);
					}
				}
                res = Math.max(res, dp[i]);
			}
		}
		
		return res;
    }
}
