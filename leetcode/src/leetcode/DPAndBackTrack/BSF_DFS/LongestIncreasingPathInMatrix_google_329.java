package leetcode.DPAndBackTrack.BSF_DFS;

public class LongestIncreasingPathInMatrix_google_329 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
		int [][] matrix = {{1}};
		System.out.println(longestIncreasingPath(matrix));
	}

	static int max = 0;
	static int [] dirs = new int [] {0,1,0,-1,0};
	static int m=0;
	static int n=0;
	
	public static int longestIncreasingPath(int[][] matrix) {
		
		if(matrix == null || matrix.length==0 || matrix[0].length == 0) return 0;
		
		m=matrix.length;
		n=matrix[0].length;
        int [][] memo = new int [m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(memo[i][j]==0)
					dfs(matrix, memo,i,j);
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(memo[i][j]+",");
				if(j==n-1) System.out.print("\n");
			}
		}
		
		
		return max;
    }
	
	
	private static int dfs(int [][] matrix, int [][] memo, int r, int c){
		if(memo[r][c]!=0) return memo[r][c];
		int cur=1;
		//search 4 directions
		for(int i=0;i<4;i++){
			int nr = dirs[i]+r;
			int nc = dirs[i+1]+c;
			//if hit walls or not larger than current
			if(nr<0 || nr>=m || nc<0 || nc>=n || matrix[nr][nc]<=matrix[r][c]) continue;
			cur = Math.max(cur, dfs(matrix, memo, nr, nc)+1);
		}
		
		memo[r][c] = cur;
		max = Math.max(cur, max);
		return cur;
	}
}
