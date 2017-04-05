package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInAnUndirectedGraph_google_323 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
