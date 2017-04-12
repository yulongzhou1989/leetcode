package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings_google_317 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int shortestDistance(int[][] grid) {
		if(grid.length==0 || grid[0].length==0) return 0;
		int m=grid.length, n=grid[0].length;
		int [][] dist = new int [m][n];
		int [][] reach = new int [m][n];
		int [] dirs = new int [] {0,1,0,-1,0};
		int buildingNum = 0;
		//start bfs for each building
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1){
					
					buildingNum ++;
					boolean [][] visited  = new boolean [m][n];
					Queue<int []> q =  new LinkedList<>();
					q.offer(new int [] {i,j});
					int level = 1;
					
					while(!q.isEmpty()){
						int size = q.size();
						for(int k=0;k<size;k++){
							int [] pos = q.poll();
							//search 4 directions
							for(int d=0;d<4;d++){
								//get next position
								int nextI = pos[0]+dirs[d];
								int nextJ = pos[1]+dirs[d+1];
								//if validate position
								if(nextI>=0 && nextI<m && nextJ>=0 && nextJ<n && grid[nextI][nextJ] == 0 && !visited[nextI][nextJ]){
									//can reachable building number ++
									reach[nextI][nextJ]++;
									//distance + level;
									dist[nextI][nextJ]+=level;
									visited[nextI][nextJ] = true;
									q.offer(new int [] {nextI, nextJ});
								}
							}
						}
						level++;
					}
				}
			}
		}
	
		//find the min distance
		int min = Integer.MAX_VALUE;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==0 && reach[i][j] == buildingNum){
					min = Math.min(min, dist[i][j]);
				}
			}
		}
		
		return min!=Integer.MAX_VALUE?min:-1;
	}
}
