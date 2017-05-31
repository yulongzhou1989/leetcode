package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class TheMazzIII_499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Position {
		int x;
		int y;
		String path;
		
		public Position(){
			
		}
		
		public Position(int x, int y){
			this.x = x;
			this.y = y;
			this.path = "";
		}
		
		public Position(int x, int y, String path){
			this.x = x;
			this.y = y;
			this.path = path;
		}
		
		public Position(int [] a){
			this.x = a[0];
			this.y = a[1];
			this.path = "";
		}
		
		public Position(int [] a, String path){
			this.x = a[0];
			this.y = a[1];
			this.path = path;
		}
	}
	
	Position [] dirs = new Position[4];

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		//bfs search, each step hit the wall one time
		if(maze==null || maze.length==0 || maze[0].length==0 || hole.length==0) return "";
		int m = maze.length;
		int n = maze[0].length;
		
		dirs[0] = new Position(-1, 0, "u");
		dirs[1] = new Position(0, 1, "r");
		dirs[2] = new Position(1, 0, "d");
		dirs[3] = new Position(0, -1, "l");
		
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(ball));
		boolean [][] visited = new boolean [m][n];
		while(!queue.isEmpty()){
			int level = queue.size();
			for(int k=0;k<level;k++){
				Position pos = queue.poll();
				//search 4 directions
				for(int i=0;i<4;i++){
					int x = pos.x+dirs[i].x;
					int y = pos.y+dirs[i].y;
					
					if(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1 && !visited[x][y]){
						pos.path += dirs[i].path; 
						//get new position
						int [] nPos = roll(maze, x, y, hole, i, m, n);
						if(nPos[0] == hole[0] &&nPos[1]==hole[1]) return pos.path;
						visited[nPos[0]][nPos[1]] = true;
						queue.offer(new Position(nPos, pos.path));
						//recover
						pos.path = pos.path.substring(0, pos.path.length()-1);
					}
				}
			}
		}
		
		return "impossible";
    }
	
	//roll the ball, when fall into hole return hole pos
	private int [] roll(int [][] maze, int x, int y, int [] hole, int i, int m, int n){
		while(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1){
			if(x==hole[0] && y==hole[1]) return new int [] {x,y};
			x += dirs[i].x;
			y += dirs[i].y;
		}
		return new int []{x-dirs[i].x, y-dirs[i].y};
	}

}
