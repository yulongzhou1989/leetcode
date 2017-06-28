package leetcode.dp;

public class PaintHouseII_265 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int minCostII(int[][] costs) {
	        if(costs==null || costs.length==0 || costs[0].length==0) return 0;
			int m = costs.length;
			int n = costs[0].length;

			int [][] dp = new int [m+1][n];
			
			for(int i=1;i<=m;i++){
				int j1 = -1, j2=-1, min1=Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;// track the index and value of the minimum and second min number
				for(int j=0;j<n;j++){//find min and second min
					//if number < min1, min1->min2, then update min1
					if(dp[i-1][j]<min1){
						min2 = min1;
						j2 = j1;
						min1 = dp[i-1][j];
						j1 = j;
					}
					else if(dp[i-1][j]<min2){
						j2 = j;
						min2 = dp[i-1][j];
					}
				}
				
				for(int j=0;j<n;j++){
					dp[i][j] = (i>1?(j!=j1?min1:min2):0) + costs[i-1][j];
					//System.out.println("i:"+ i + ",j:"+j + ",dp[i][j]:" + dp[i][j] +",min1:"+ min1+",min2:"+min2 + ",j1:" + j1);
				}
			}  
			
			int min = Integer.MAX_VALUE;
			for(int num:dp[m]){
				min = Math.min(min, num);
			}
			
			return min;
	    }
}
