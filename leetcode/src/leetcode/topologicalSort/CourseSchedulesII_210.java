package leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedulesII_210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//DFS topologic sort
	public int[] findOrder2(int numCourses, int[][] pres) {
        //initial map
		List<List<Integer>> adjs = new ArrayList<>();
		for(int i=0;i<numCourses;i++){
			adjs.add(new ArrayList<>());
		}
		for(int [] a:pres){
			adjs.get(a[1]).add(a[0]);
		}
		
		List<Integer> list = new ArrayList<>();
		boolean [] visited = new boolean [numCourses];
		boolean [] onPath = new boolean [numCourses];
		for(int i=0;i<adjs.size();i++){
			if(!visited[i] && !dfs(list, adjs, i, visited, onPath)) return new int [0];
		}
		
		int [] res = new int [numCourses];
		for(int i=0;i<numCourses;i++){
			res[i] = list.get(numCourses-i-1);
		}
		return res;
    }
	
	private boolean dfs(List<Integer> list, List<List<Integer>> adjs, int cur, boolean [] visited, boolean [] onPath){
	    visited[cur] = onPath[cur] = true;
	    
	    for(int i:adjs.get(cur)){
	        if(onPath[i] || (!visited[i] && !dfs(list, adjs, i, visited, onPath))) return false;
	    }
	    
	    list.add(cur);
	    onPath[cur] = false;
	    return true;
	}

	//BFS topologic sort 
	public int[] findOrder(int numCourses, int[][] pres) {
        int [][] adjs = new int [numCourses][numCourses];
		int [] indegree = new int [numCourses];
		
		for(int [] a: pres){
			adjs[a[1]][a[0]] = 1;
			indegree[a[0]]++;
		}
		
		//prepare q for BFS
		Queue<Integer> queue = new LinkedList<>();
		int [] res = new int [numCourses];
		int pos = 0;
		for(int i=0;i<numCourses;i++){
			if(indegree[i]==0){
				queue.offer(i);
				res[pos++] = i;
			} 
		}
		
		while(!queue.isEmpty()){
			int cur = queue.poll();
			for(int i=0;i<numCourses;i++){
				if(adjs[cur][i]==1){
					if(--indegree[i]==0){
						res[pos++] = i;
						queue.offer(i);
					}
				}
			}
		}
		
		return pos==numCourses?res:new int [] {};
    }
}
