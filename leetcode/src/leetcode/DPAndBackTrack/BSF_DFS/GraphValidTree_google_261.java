package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree_google_261 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//DFS way
//	public boolean validTree(int n, int[][] edges) {
//        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
//        
//        //Initial new list
//        for(int i=0;i<n;i++){
//            adjList.add(i, new ArrayList<Integer>());
//        }
//        //Inital edges
//        for(int i=0;i<edges.length;i++){
//            adjList.get(edges[i][0]).add(edges[i][1]);
//            adjList.get(edges[i][1]).add(edges[i][0]);
//        }
//        //check loop
//        boolean [] visited  = new boolean [n];
//        if(checkLoop(adjList, 0, visited, -1))
//            return false;
//        //check isolated nodes
//        for(int i=0; i<n;i++){
//            if(!visited[i])
//                return false;
//        }
//        
//        return true;
//    }
//    
//    private boolean checkLoop(List<List<Integer>> adjList, int v, boolean [] visited, int parent){
//        visited[v] = true;
//        
//        for(int i=0;i<adjList.get(v).size();i++){
//            int u = adjList.get(v).get(i);
//            if((parent != u && visited[u]) || (!visited[u] && checkLoop(adjList, u, visited, v)))
//                return true;
//        }
//        return false;
//    }
	
	//BFS way
	public boolean validTree(int n, int[][] edges) {
        int [] visited = new int [n];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        
        for (int i=0;i<n;i++){
            adjList.add(i, new ArrayList());
        }
        
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0); visited[0] = 1;
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer cur:adjList.get(u)){
                if(visited[cur] == 1) return false;
                if(visited[cur] == 0) {visited[cur]=1; q.offer(cur);}
            }
            visited[u] = 2;
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0) return false;
        }
        
        return true;
    }
}
