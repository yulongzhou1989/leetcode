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
		int dir;
		
		public Position(){
			
		}
		
		public Position(int x, int y, String path){
			this.x = x;
			this.y = y;
			this.path = path;
		}
		
		public Position(int x, int y, String path, int dir){
			this.x = x;
			this.y = y;
			this.path = path;
			this.dir = dir;
		}
	}
	
	Position [] dirs = new Position[4];

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		//bfs search, each step hit the wall one time
		if(maze==null || maze.length==0 || maze[0].length==0 || hole.length==0) return "";
		int m = maze.length;
		int n = maze[0].length;
		
		dirs[0] = new Position(1, 0, "d");
		dirs[1] = new Position(0, -1, "l");
		dirs[2] = new Position(0, 1, "r");
		dirs[3] = new Position(-1, 0, "u");
		
		Queue<Position> queue = new LinkedList<>();
		boolean [][][] visited = new boolean [m][n][4];
		
		//push 4 directions into q
		for(int i=0;i<4;i++){
			int x = ball[0]+dirs[i].x;
			int y = ball[1]+dirs[i].y;
			if(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1)
				queue.offer(new Position(x, y ,dirs[i].path,i));
		}

		while(!queue.isEmpty()){
		    int level = queue.size();
		    for(int k=0;k<level;k++){
    			Position pos = queue.poll();
    			visited[pos.x][pos.y][pos.dir] = true;
				if(pos.x==hole[0] && pos.y==hole[1]) return pos.path;
    			System.out.println("x:"+pos.x +",y:"+pos.y +",path:"+pos.path+",dir:"+pos.dir);
    			int x = pos.x+dirs[pos.dir].x;
    			int y = pos.y+dirs[pos.dir].y;
				
    			if(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1 && !visited[x][y][pos.dir]){
    				queue.offer(new Position(x, y, pos.path, pos.dir));
    			}
    			else{//need change direction
    				//search other 3 directions
    				for(int i=0;i<4;i++){
    				    if(i==pos.dir) continue;
    					x = pos.x+dirs[i].x;
						y = pos.y+dirs[i].y;
						if(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1 && !visited[x][y][i]){
    						queue.offer(new Position(x, y, pos.path+dirs[i].path, i));
    					}
    				}
    			}
		    }
		}
		
		return "impossible";
    }

}
