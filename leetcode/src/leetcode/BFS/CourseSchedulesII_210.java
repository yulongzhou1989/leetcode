package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedulesII_210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//

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
