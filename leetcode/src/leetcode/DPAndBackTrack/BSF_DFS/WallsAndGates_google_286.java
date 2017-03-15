package leetcode.DPAndBackTrack.BSF_DFS;

public class WallsAndGates_google_286 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    int [] directions = {0,1,0,-1,0}; 
    
    public void wallsAndGates(int[][] rooms) {
        //find the door and start the dfs
        for(int i=0;i<rooms.length;i++){
            for (int j=0;j<rooms[0].length;j++){
                if (rooms[i][j]==0)
                    helper(rooms, i, j, 0);
            }
        }
    }
    
    void helper(int [][] rooms, int row, int col, int d){
        // search 4 directions
        for(int i=0;i<4;i++){
            int r = row+directions[i];
            int c = col+directions[i+1];
            if (r<0 || r>=rooms.length || c<0 || c>=rooms[0].length || rooms[r][c] == -1 || rooms[r][c]<d+1) continue;
            rooms[r][c] = d+1;
            helper(rooms, r, c, d+1);
        }
    }
}
