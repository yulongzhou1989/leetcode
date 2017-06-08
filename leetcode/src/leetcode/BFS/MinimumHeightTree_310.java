package leetcode.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTree_310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//topological sort
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
		if(n==0) return leaves;
		if(n==1) return Collections.singletonList(0);
		
		List<HashSet<Integer>> map = new ArrayList<>();
		
		for(int i=0;i<n;i++){
		    map.add(new HashSet());
		}
		
		for(int [] e: edges){
			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}
		
		for(int i=0;i<n;i++){
			if(map.get(i).size()==1) leaves.add(i);
		}

		while(n>2){
			//leaves size == degree
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int i:leaves){
				int j = map.get(i).iterator().next();
				map.get(j).remove(i);
				if(map.get(j).size()==1) newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		
		return leaves;
    }
}
