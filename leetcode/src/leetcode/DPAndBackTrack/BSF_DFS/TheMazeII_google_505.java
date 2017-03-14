package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.Arrays;

public class TheMazeII_google_505 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [][] maze = {
//			{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}	
//		};
		int [][] maze = {
				{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}	
		};
		//int [] des = {0,0};
		int [] start = {0,4};
		int [] des = {4,4};
		System.out.println(shortestDistance(maze, start, des));
	}
	
//	static final int[] DIRS = {0, 1, 0, -1, 0};
//	public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
//	    int[][] dist = new int[maze.length][maze[0].length];
//	    dist[start[0]][start[1]] = 1;
//	    dfs(start[0], start[1], destination, maze, dist);
//	    return dist[destination[0]][destination[1]] - 1;
//	}
//	static void dfs(int row, int col, int[] dest, int[][] maze, int[][] dist) {
//	    if (row == dest[0] && col == dest[1]) return;
//	    int m = maze.length, n = maze[0].length;
//	    for (int d = 0; d < 4; ++d) {
//	        int i = row, j = col, p = DIRS[d], q = DIRS[d + 1], len = dist[row][col];
//	        while (i + p >= 0 && i + p < m && j + q >= 0 && j + q < n && maze[i + p][j + q] == 0) {
//	            i += p;
//	            j += q;
//	            len++;
//	        }
//	        if (dist[i][j] > 0 && len >= dist[i][j]) continue;
//	        dist[i][j] = len;
//	        dfs(i, j, dest, maze, dist);
//	    }
//	}

	static int [] Directions = {0,1,0,-1,0};
    
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
    	int [][]dist = new int [maze.length][maze[0].length];
    	dist[start[0]][start[1]] = 1;
        helper(maze, start, destination, new boolean [maze.length][maze[0].length], dist);
    	return dist[destination[0]][destination[1]]-1;
    }
    
    //DFS find shortest path
    public static void helper(int [][] maze, int [] start, int [] destination, boolean [][] visited, int [][]dist){
        //find return
        if (Arrays.equals(start, destination)) return;
        //visited return
//        if (visited[start[0]][start[1]]) return;
//        visited[start[0]][start[1]] = true;
        
        //search 4 directions
        for (int i=0;i<Directions.length-1;i++){
            int row = start[0];
            int col = start[1];
            int len = dist[start[0]][start[1]];
            //roll until stop
            while(canRoll(maze, row+Directions[i], col+Directions[i+1])){
                row += Directions[i];
                col += Directions[i+1];
                len++;
            }
            
            if (dist[row][col]>0 && len>=dist[row][col]) continue;
            dist[row][col] = len;
            helper(maze, new int [] {row, col}, destination, visited, dist);
        }
    }
    
    public static boolean canRoll(int [][] maze, int row, int col){
        if (row<maze.length && row>=0 && col<maze[0].length && col>=0 && maze[row][col] == 0)
            return true;
        return false;
    }
}
