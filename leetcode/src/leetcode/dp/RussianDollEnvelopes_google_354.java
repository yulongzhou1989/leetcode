package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes_google_354 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//On*logn time complexity
		public int maxEnvelopes(int[][] envelopes) {
	        //use a proirity queue hight small->big, width small->big
			//dp[i] = max(1, (0->i)dp[j]+1 | can match)
			if(envelopes==null || envelopes.length==0 || envelopes[0].length==0) return 0;
			int n = envelopes.length;
			int [] dp = new int [n];
			
			Arrays.sort(envelopes, new Comparator<int []> () {
				@Override
				public int compare(int [] a, int [] b){
					if(a[0] == b[0]) return b[1]-a[1];
					else return a[0]-b[0];
				}
			});
			
			int len = 0;
			for(int [] env : envelopes){
				int index = Arrays.binarySearch(dp, 0, len, env[1]);
				if(index <0) index = -(index+1);
				dp[index] = env[1];
				if(index == len)
					len++;
			}
			
			return len;
	    }

	//On*n time complexity
	public int maxEnvelopes1(int[][] envelopes) {
        //use a proirity queue hight small->big, width small->big
		//dp[i] = max(1, (0->i)dp[j]+1 | can match)
		if(envelopes==null || envelopes.length==0 || envelopes[0].length==0) return 0;
		int n = envelopes.length;
		int [] dp = new int [n];
		
		Arrays.sort(envelopes, new Comparator<int []> () {
			@Override
			public int compare(int [] a, int [] b){
				if(a[0] == b[0]) return a[1]-b[1];
				else return a[0]-b[0];
			}
		});
		
		int max = 1;
		for(int i=0;i<n;i++){
			dp[i] = 1;
			for(int j=0;j<i;j++){
				if(fit(j, i, envelopes))
					dp[i] = Math.max(dp[i], dp[j]+1);
				max = Math.max(dp[i], max);
			}
		}
		
		return max;
    }
	
	//put j to i
	private boolean fit(int j, int i, int [][] e){
		if(e[i][0]>e[j][0] && e[i][1]>e[j][1]) return true;
		else return false;
	}
	
}
