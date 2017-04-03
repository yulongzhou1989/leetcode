package contest;

public class FriendCycles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = new int [][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}; 
		System.out.println(findCircleNum(matrix));
	}

	public static int findCircleNum(int[][] M) {
        if(M.length==0) return 0;
        int count =0;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    //dfs
                    search(M, i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static void search(int [][] M, int row, int col){
        if(row<0|| row>=M.length||col<0|| col>=M[0].length||M[row][col]==0) return;
    	M[row][col]=0;
    	for(int j=0;j<M[0].length;j++){
    	    if(M[row][j] == 1){
    	        M[row][j] = 0;
    	        search(M, j, row);
    	    }
    	}
    }
}
