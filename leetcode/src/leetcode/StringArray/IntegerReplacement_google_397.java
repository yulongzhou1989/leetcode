package leetcode.StringArray;

public class IntegerReplacement_google_397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O1 space, O(b) time
	public int integerReplacement(int n) {
        if(n==Integer.MAX_VALUE) return 32; 
        //let the number of bit 1 decrease ASAP
		int res = 0;
		while(n!=1){
			if(n%2==0) n=n/2;
			else{
				//end with 01
				if(((n>>>1)&1)==0 || n==3)
					n--;
				else 
					n++;
			}
			res++;
		}
			
		return res;
    }
	

	//on space lol
	public int integerReplacement1(int n) {
        if(n<2) return 0;
		
		int [] dp = new int [n+1];
		dp[1] = 0;
		dp[2] = 1;
		
		//if(even) f(n) = f(n/2), if(odd) f(n) = min(f(n-1),f((n+1)/2)+1);
		for(int i=3;i<=n;i++){
			if(i%2==0) dp[i] = dp[i/2]+1;
			if(i%2==1) dp[i] = Math.min(dp[i-1]+1, dp[(i+1)/2]+2);
		}
		
		return dp[n];
    }
}
