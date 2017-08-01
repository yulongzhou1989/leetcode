package leetcode.BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII_google_407 {
	class Ceil{
		int row;
		int col;
		int height;
		
		public Ceil(){
			
		}
		
		public Ceil(int row, int col, int height){
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}
	
	public int trapRainWater(int[][] heights) {
		if(heights==null || heights.length==0 || heights[0].length==0) return 0;
		
		PriorityQueue<Ceil> pq = new PriorityQueue<>(new Comparator<Ceil>(){
			@Override 
			public int compare(Ceil a, Ceil b){
				return a.height-b.height;
			}
		});
		int m = heights.length;
		int n = heights[0].length;
		boolean [][] visited = new boolean [m][n];
		
		//initial, add 4 borders into q
		for(int i=0;i<m;i++){
			pq.offer(new Ceil(i, 0, heights[i][0]));
			pq.offer(new Ceil(i, n-1, heights[i][n-1]));
			visited[i][0] = visited[i][n-1] = true;
		}
		
		for(int i=0;i<n;i++){
			pq.offer(new Ceil(0, i, heights[0][i]));
			pq.offer(new Ceil(m-1, i, heights[m-1][i]));
			visited[0][i] = visited[m-1][i] = true;
		}
		
		int [][] dirs = new int [][] {{-1,0},{0, 1}, {1, 0}, {0, -1}};
		int res = 0;
		while(!pq.isEmpty()){
			Ceil c = pq.poll();
			for(int i=0;i<4;i++){//search 4 directions
				int row = c.row + dirs[i][0];
				int col = c.col + dirs[i][1];
				if(row>=0 && row<m && col>=0 && col<n && !visited[row][col]){
					visited[row][col] = true;
					res += Math.max(0, c.height-heights[row][col]);
					pq.offer(new Ceil(row, col, Math.max(c.height, heights[row][col])));
				}
			}
		}
		
		return res;
    }
}
