package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.Arrays;

public class TheMaze_google_490 {

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
		int [] des = {1,2};
		//System.out.println(hasPath(maze, start, des));
	}
	
	int [] Directions = {0,1,0,-1,0};
	
	public boolean hasPath(int [][] maze, int []start, int [] distination){
		boolean [][] visited = new boolean [maze.length][maze[0].length];
		return dfs(maze, start, distination, visited, new boolean [maze.length][maze[0].length]);
	}
	
	public boolean dfs(int [][] maze, int [] start, int [] distination,boolean [][] visited, boolean [][] failed){
		if (visited[start[0]][start[1]]) return false;
		if (Arrays.equals(start,distination)) return true;
		if (failed[start[0]][start[1]]) return false;
		
		visited[start[0]][start[1]] = true;
		
		for (int i=0; i<Directions.length; i++){
			int [] newStart = roll(maze, start[0], start[1], Directions[i], Directions[i+1]);
			if(dfs(maze, newStart, distination, visited, failed)) return true;
		}
		failed[start[0]][start[1]] = true;
		return false;
	}
	
	public int [] roll(int [][] maze, int row, int col, int rowInc, int colInc){
		while(canRoll(maze, row+rowInc, col+colInc)){
			row+=rowInc;
			col+=colInc;
		}
		
		return new int [] {row,col};
	}
	
	public boolean canRoll(int [][]maze, int row, int col){
		if (row>=maze.length || row<0 || col>=maze[0].length || col <0 || maze[row][col]==1)
			return false;
		return true;
	}
	
//    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        if (maze.length==0 || start.length<1 || destination.length<1) return false;
//        boolean [][] failedPosition = new boolean [maze.length][maze[0].length];
//        status [][] visited = new status [maze.length][maze[0].length];
//        return helper(maze, start[0], start[1], destination[0], destination[1], failedPosition, visited, null);
//    }
//    
//    static boolean helper (int [][] maze, int startRow, int startCol, int desRow, int desCol
//    		, boolean [][] failedPosition, status [][] visited, direction dir){
//    	//if bondray and wall
//        if (startRow<0 || startCol<0 || startRow>=maze.length || startCol>=maze[0].length || maze[startRow][startCol]==1)
//            return false;
//        //if failed in this point before    
//        if (failedPosition[startRow][startCol]) return false;
//        //if is visiting
//        if (visited[startRow][startCol] == status.visiting) return false;
//        if (startRow == desRow && startCol == desCol && !canStop(maze, desRow, desCol, dir)) return false;
//        
//        //if is destination, return true;
//        visited[startRow][startCol] = status.visiting;
//        if ((startRow == desRow && startCol == desCol) 
//        	||helper (maze, startRow-1, startCol, desRow, desCol, failedPosition, visited, direction.up)
//            ||helper (maze, startRow+1, startCol, desRow, desCol, failedPosition, visited, direction.down)
//            ||helper (maze, startRow, startCol-1, desRow, desCol, failedPosition, visited, direction.left)
//            ||helper (maze, startRow, startCol+1, desRow, desCol, failedPosition, visited, direction.right)
//            ) {
//        	//if (canStop(maze, desRow, desCol, dir)) 
//        		return true;
//        }
//
//        //save cache result
//        failedPosition[startRow][startCol] = true;
//        visited[startRow][startCol] = status.visited;
//        return false;
//    }
//    
//    static boolean canStop(int [][] maze, int row, int col, direction dir){
//        if(dir==direction.left && (col==0 || maze[row][col-1]==1)) return true;
//        else if(dir==direction.right && (col==maze[0].length || maze[row][col+1] == 1)) return true;
//        else if(dir==direction.up && (row==0 || maze[row-1][col]==1)) return true;
//        else if(dir==direction.down && (row==maze.length || maze[row+1][col]==1))  return true;
//        else return false;
//    }
//    
//    enum status {visited, visiting, unvisited}
//    enum direction {up, down, left, right}
}

