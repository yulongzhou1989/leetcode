package leetcode.topologicalSort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class SequenceReconstruction_google_444 {
	//5->2->6->3  4->1->5->2
		//when we do topological sort, we can only find one way to have degree ==0 each step to the end.
		
		public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
			if(org==null || org.length==0) return false;
			HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
			int n = org.length;
			int [] inDegrees = new int [n];
			
			for(List<Integer> seq: seqs){//initial map and indgree
				if(seq.size()>1){
					for(int i=0;i<seq.size()-1;i++){
						int a = seq.get(i);
						int b = seq.get(i+1);
						if(!map.containsKey(a)){
							map.put(a, new HashSet<>());
						}
						map.get(a).add(b);
						inDegrees[b]++;
					}
				}
			}
			
			//Queue<Integer> queue
			
			return false;
	    }
}
