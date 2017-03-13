package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.Arrays;

public class TheMazeII_google_505 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

int [] Directions = {0,1,0,-1,0};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        return helper(maze, start, destination, new boolean [maze.length][maze[0].length], new int [maze.length][maze[0].length]);
    }
    
    //DFS find shortest path
    public int helper(int [][] maze, int [] start, int [] destination, boolean [][] visited, int [][]dist){
        //find return
        if (Arrays.equals(start, destination)) return dist[start[0]][start[1]];
        //visited return
        if (visited[start[0]][start[1]]) return -1;
        visited[start[0]][start[1]] = true;
        
        //search 4 directions
        int len = dist[start[0]][start[1]];
        for (int i=0;i<Directions.length-1;i++){
            int row = start[0];
            int col = start[1];
            //roll until stop
            while(canRoll(maze, row+Directions[i], col+Directions[i+1])){
                row += Directions[i];
                col += Directions[i+1];
                len++;
            }
            
            if (dist[row][col]>0 && len>=dist[row][col]) continue;
            dist[row][col] = helper(maze, new int [] {row, col}, destination, visited, dist);
        }
        
        return -1;
    }
    
    public boolean canRoll(int [][] maze, int row, int col){
        if (row<=maze.length && row>=0 && col<=maze[0].length && col>=0 && maze[row][col] != 1)
            return true;
        return false;
    }
}
