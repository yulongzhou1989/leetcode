package leetcode.dp;

public class EncodeStringWithShortestLength_google_471 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String encode(String s) {
        if(s==null || s.length()==0) return s;
		//dp[i,j] = min(dp[i,k]) + min(dp[k,j]);
		int n = s.length();
		String [][] dp = new String [n][n];
		for(int len=0; len<n; len++){
			for(int i=0; i<n-len;i++){// the sub string with len length and with i start point
				int j = i+len;
				String subString = s.substring(i,j+1);
				if(j-i<4){//base condition
					dp[i][j] = subString;
				} else{
                    dp[i][j] = subString;
					for(int k = i;k<j; k++){
						if((dp[i][k] + dp[k+1][j]).length()<dp[i][j].length()){
							dp[i][j] = dp[i][k] + dp[k+1][j];
						}
					}
					
					//check if we can shorten the result
					for(int k=0; k<=subString.length()/2;k++){
						String replaceString = subString.substring(0, k+1);
						if(replaceString!=null && subString.length()%replaceString.length()==0 
						&& subString.replace(replaceString,"").equals("")){
							String ss = subString.length()/replaceString.length() + "[" + dp[i][i+k]+ "]";
							if(ss.length()<dp[i][j].length()){
								dp[i][j] = ss;
							}
						}
					}
				}
			}
		}
		
		return dp[0][n-1];
    }

}
