package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class OnesAndZeros_google_474 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = {"10","0001","111001","1","0"};
		System.out.println(findMaxForm(strs,3,4));
	}

	
	public static int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, new ArrayList<String>(), 0, 0);
    }
    
    private static int helper(String []  strs, int m, int n, List<String> tempList, int max, int pos){
        for(int i=pos;i<strs.length;i++){
            int [] counts = countOnesAndZeros(strs[i]);
            if (m-counts[0]<0 || n-counts[1]<0) continue;
            tempList.add(strs[i]);
            max = Math.max(helper(strs, m-counts[0], n-counts[1], tempList, tempList.size(), i+1), max);
            tempList.remove(tempList.size()-1);
        }
        
        return max;
    }
    
  //dp[m][n] = max(1+dp[m-counts[0]][n-count[1]], dp[m][n]), dp solution
    public int findMaxForm1(String[] strs, int m, int n) {
        int [][] dp = new int [m+1][n+1];
        for (String s:strs){
            int [] count = countOnesAndZeros(s);
            for(int i=m;i>=count[0];i--){
                for(int j=n;j>=count[1];j--){
                    dp[i][j] = Math.max(1+dp[i-count[0]][j-count[1]],dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    
    //count number of 0s and 1s
    private static int [] countOnesAndZeros(String s){
        int ones = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') ones++;
        }
        return new int [] {s.length()-ones, ones};
    }
}
