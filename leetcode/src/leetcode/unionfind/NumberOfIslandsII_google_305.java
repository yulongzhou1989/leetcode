package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII_google_305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//UNION AND FIND
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
		List<Integer> res = new ArrayList<>();
		if(positions.length==0 && positions[0].length==0) return res;
		int [] roots = new int [m*n];
		Arrays.fill(roots, -1);
		int [] dirs = new int [] {0,1,0,-1,0};
		int count = 0;
		
		//save positions as a tree structure, when new position added, save conjected position
		for(int [] pos:positions){
			int root = pos[0]*n+pos[1];
			roots[root] = root;
			count++;
			
			for(int i=0;i<4;i++){
				int x = pos[0]+dirs[i];
				int y = pos[1]+dirs[i+1];
				int nr = x*n+y;
				//if has conjected pos
				if(x>=0 && x<m && y>=0 && y<n && roots[nr]!=-1){
					int rootN = findIsland(roots,nr);
					//if neighbor is another island,union two island, current tree root = joined tree root
					if(rootN != root){
						roots[root] = rootN;
						root=rootN;
						count--;
					}
				}
			}
			res.add(count);
		}
		
		return res;
    }
    
    private int findIsland(int [] roots, int nr){
        while(nr!=roots[nr]) nr = roots[nr];
        return nr;
    }
}
