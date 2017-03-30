package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix01_google_542 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n= matrix.size();
        int m= matrix.get(0).size();
        Queue<int []> q = new LinkedList<int []>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0) {
                    q.offer(new int [] {i,j});
                }else {
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }
        
        int [] dirs = {0, 1, 0, -1, 0};
        while(!q.isEmpty()){
            int [] cell = q.poll();
            for (int i=0;i<4;i++){
                int r = cell[0]+dirs[i];
                int c = cell[1]+dirs[i+1];
                if(r<0 || r>=n ||c<0||c>=m || matrix.get(r).get(c)<=matrix.get(cell[0]).get(cell[1])+1){
                    continue;
                }
                q.offer(new int [] {r,c});
                matrix.get(r).set(c, matrix.get(cell[0]).get(cell[1])+1);
            }
        }
        
        
        return matrix;
    }

}
