package leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSechedule_207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//topological sort
	public boolean canFinish(int numCourses, int[][] pres) {
		int [][] adjs = new int [numCourses][numCourses];
		int [] indegrees = new int [numCourses];
		//initial adjacent matrix
		for(int [] a: pres){
			indegrees[a[0]]++;
			adjs [a[1]][a[0]] = 1;//i->j
		}
		
		//bfs search
		Queue<Integer> queue = new LinkedList<>();
		//initial queue
		for(int i=0;i<indegrees.length;i++){
			if(indegrees[i]==0) queue.offer(i);
		}
		int count = 0;
		while(!queue.isEmpty()){
			int cur = queue.poll();
			count ++;
			for(int i=0;i<numCourses;i++){
				if(adjs[cur][i] == 1){
					if(--indegrees[i]==0)
						queue.offer(i);
				}
			}
		}
		
		return count==numCourses;
	}
	
	//DFS way 
    public boolean canFinish2(int numCourses, int[][] pres) {
        if(pres==null || pres.length==0 || pres[0].length==0) return true;
        ArrayList [] arr = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            arr[i] = new ArrayList();
        for(int [] a: pres){
            arr[a[1]].add(a[0]);
        }  
        
        boolean [] visited = new boolean [numCourses];
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, arr, visited)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int cur, ArrayList [] arr, boolean [] visited){
        if(visited[cur]) return false;
        visited[cur] = true;
        for(int i=0;i<arr[cur].size();i++){
            if(!dfs((int)arr[cur].get(i), arr , visited)) return false;
        }
        visited[cur] = false;
        return true;
    }

	//general way LTE
	public boolean canFinish1(int numCourses, int[][] pres) {
        if(pres==null || pres.length==0 || pres[0].length==0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int [] a: pres){
            int x = a[0];
            int y = a[1];
            if(!map.containsKey(y)){
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }  
        
        boolean [] visited = new boolean [numCourses];
        for(Integer cur:map.keySet()){
            if(!dfs(cur, map, visited)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int cur, Map<Integer, List<Integer>> map, boolean [] visited){
        if(visited[cur]) return false;
        if(!map.containsKey(cur)) return true;
        visited[cur] = true;
        for(Integer i: map.get(cur)){
            if(!dfs(i, map, visited)) return false;
        }
        visited[cur] = false;
        return true;
    }
}
