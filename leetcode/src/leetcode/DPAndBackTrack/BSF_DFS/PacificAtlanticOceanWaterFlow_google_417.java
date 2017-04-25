package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticOceanWaterFlow_google_417 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

int [] dirs = new int [] {0,1,0,-1,0};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<>();
        int m = matrix.length, n=matrix[0].length;
        boolean [][] atlantic = new boolean [m][n]; 
        boolean [][] pacific = new boolean [m][n];
        Queue<int []> pQueue = new LinkedList<int []>();
        Queue<int []> aQueue = new LinkedList<int []>();
        
        List<int []> list = new ArrayList<int []>();
        //initial q, horizontal
        for(int i=0;i<n;i++){
            pQueue.offer(new int [] {0, i});
            aQueue.offer(new int [] {m-1, i});
            atlantic[0][i] = true;
            pacific[m-1][i] = true;
        }
        //initial q, vertical
        for(int i=0;i<m;i++){
            pQueue.offer(new int [] {i,0});
            aQueue.offer(new int [] {i, n-1});
            atlantic[i][0] = true;
            pacific[i][n-1] = true;
        }
        
        bfs(matrix, pQueue, atlantic);
        bfs(matrix, aQueue, pacific);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    list.add(new int [] {i,j});
                }
            }
        }
        
        return list;
    }
    
    public void bfs(int [][] matrix, Queue<int []> q, boolean [][] visited){
        int m = matrix.length;
        int n = matrix[0].length;
        while(!q.isEmpty()){
            int [] position = q.poll();
            //search 4 directions
            for(int i=0;i<4;i++){
                int newRow = position[0] + dirs[i];
                int newCol = position[1] + dirs[i+1];
                if(newRow<0 || newCol<0 || newRow>=m || newCol>=n || visited[newRow][newCol] 
                    || matrix[newRow][newCol]<matrix[position[0]][position[1]]) continue;
                visited[newRow][newCol] = true;
                q.offer(new int [] {newRow, newCol});
            }
        }
    }
}
