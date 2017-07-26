package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NumberOfConnectedComponentsInAnUndirectedGraph_google_323 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Union find way
	class Union {
		int [] parents;
		int [] ranks;
		int count;
		
		public Union(int n){
			parents = new int [n];
			ranks = new int [n];
			count = 0;
		}
		
		public int getID(int i){
			return parents[i];
		}
		
		public int getCount(){
			return count;
		}
		
		public int root(int i){
			for(;parents[i]!=i;i=parents[i]){
				parents[i] = parents[parents[i]];//compression
			}
			return i;
		}
		
		public int add(int i){
			parents[i] = i;
            ranks[i]=1;
			count++;
			return i;
		}
        
        public boolean find(int p, int q){
            return root(p)==root(q);
        }
		
		public void unite(int p, int q){
			int i = root(p), j= root(q);
			if(ranks[i]<ranks[j]){//fast add
				ranks[j]+=ranks[i];
				parents[i] = j;
			}else{
				ranks[i] += ranks[j];
				parents[j] = i;
			}
			count--;
		}
	}
	
	//unite based on the edges, return union count
	public int countComponents2(int n, int[][] edges) {
		if(n<2) return n;
		Union un = new Union(n);
		for(int i=0;i<n;i++){
			un.add(i);
		}
		for(int [] e:edges){
            if(!un.find(e[0], e[1]))//check if these 2 has joint
			    un.unite(e[0], e[1]);
            //System.out.println(un.getCount());
		}
		
		return un.getCount();
    }
	
	//bfs way
	public int countComponents1(int n, int[][] edges) {
        if(n<2) return n;
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        HashSet<Integer> counts = new HashSet<>();
        
        for(int i=0;i<edges.length;i++){
            if(!map1.containsKey(edges[i][0]))
                map1.put(edges[i][0], new ArrayList<>());
            if(!map2.containsKey(edges[i][1]))
                map2.put(edges[i][1], new ArrayList<>());
            map1.get(edges[i][0]).add(edges[i][1]);
            map2.get(edges[i][1]).add(edges[i][0]);
            counts.add(edges[i][0]);
            counts.add(edges[i][1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(map1.containsKey(i) || map2.containsKey(i)){
                queue.offer(i);
                count++;
                while(!queue.isEmpty()){
                    int j = queue.poll();
                    if(map1.containsKey(j)){
                        for(int k:map1.get(j))
                            queue.offer(k);
                    }
                    if(map2.containsKey(j)){
                        for(int k:map2.get(j))
                            queue.offer(k);
                    }
                    map1.remove(j);
                    map2.remove(j);
                }
            }
        }
        
        return count + n - counts.size();
        
    }
	//dfs way
	boolean [] visited;
	Map<Integer, List<Integer>> map;
	public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
		//initial visited
		visited = new boolean [n];
		//initial map
		for(int i=0;i<n;i++){
			map.put(i, new ArrayList<>());
		}
		for(int [] edge:edges){
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		int count = 0;
		for(int i=0;i<n;i++){
			//dfs search
			if(!visited[i]){
				dfs(i);
				count++;
			}
		}
		
		return count;
    }
	
	private void dfs(int i){
		visited[i] = true;
		for(int j:map.get(i)){
		    if(!visited[j]) dfs(j);
		}
	}
}
