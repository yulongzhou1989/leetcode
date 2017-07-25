package leetcode.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII_google_305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> numIslands21(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
		if(positions==null || positions.length==0) return list;
		Union un = new Union(m, n);//initial union map
		int [][] dirs = new int [][] {{0,-1},{-1,0},{1,0},{0,1}};
		//add each node to the union, then search 4 directions check if we can merge it
		for(int [] pos: positions){
			int x = pos[0], y = pos[1];
			int p = un.add(x, y);
			for(int [] d: dirs){
				int q = un.getId(x+d[0], y+d[1]);//check existed of current node
                //System.out.println(Arrays.toString(un.parents));
				if(q>0 && !un.find(p, q)){
					un.unite(p,q);
				}
			}
			list.add(un.getCount());
		}
		
		return list;
    }
	
	class Union{
		
		public int [] parents;
		int [] ranks;
		int m, n, count;
		
		public Union(int m, int n){
			this.m = m;
			this.n = n;
			this.parents = new int [m*n+1];
			this.ranks = new int [m*n+1];
			this.count = 0;
		}
		
		public int getCount(){
			return count;
		}
		
		public int index(int x, int y){
			return x*n+y+1;
		}
		
		public int getId(int x, int y){
			if(x>=0 && x<m && y>=0 && y<n)
				return parents[index(x, y)];
			else
				return 0;
		}
		
		public int add(int x, int y){
			int i = index(x, y);
			parents[i] = i;
			ranks[i] = 1;
			count++;
			return i;
		}
		
		public boolean find(int p, int q){
			return root(p) == root(q);
		}
		
		public void unite(int p, int q){
			int i = root(p), j = root(q);
			if(ranks[i]<ranks[j]){//fast unite by ranks/weight
				parents[i] = j; 
				ranks[j] += ranks[i];
			}else{
				parents[j] = i;
				ranks[i] += ranks[j];
			}
			
			count--;
		}
		
		
		public int root(int i){
			for(;i!=parents[i]; i=parents[i]){
				parents[i] = parents[parents[i]];//compression tree structure
			}
			
			return i;
		} 
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
