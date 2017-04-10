package leetcode.DPAndBackTrack;

public class GuessNumberHigherOrLowerII_google_375 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMoneyAmount(int n) {
        return DP(1,n, new int [n+1][n+1]);
    }
    
    private int DP(int start, int end, int [][]res){
        if(start>=end) return 0;
        if(res[start][end]!=0) return res[start][end];
        int min = Integer.MAX_VALUE;
        for(int i=start; i<=end;i++){
            int temp = i+Math.max(DP(start, i-1, res),DP(i+1, end, res));
            min = Math.min(temp, min);
        }
        res[start][end] = min;
        return res[start][end];
    }
}
