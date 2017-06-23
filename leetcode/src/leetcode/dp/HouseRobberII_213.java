package leetcode.dp;

public class HouseRobberII_213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int houseRobber(int[] A, int l, int h) {
        
		int rob = 0;
		int unRob = 0;
		//dp[i] = max(dp[i-2] + A[i], dp[i-1])
		for(int i=l;i<h;i++){
			int preRob = rob;
			rob = unRob+A[i];
			unRob = Math.max(preRob, unRob);
		}
		
		return Math.max(rob, unRob);
    }
	
	public int rob(int [] A){
		if(A==null || A.length==0) return 0;
        if(A.length==1) return A[0];
        
		int n = A.length;
		return Math.max(houseRobber(A, 0, n-1), houseRobber(A, 1, n)); 
	}

}
