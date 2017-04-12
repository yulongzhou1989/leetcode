package leetcode.sort.DivideAndConque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem_google_218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<int[]> getSkyline(int[][] buildings) {
        List<int []> res = new ArrayList<>();
		List<int []> height = new ArrayList<>();
		//initial height, start point save negative value
		for(int [] b: buildings){
			height.add(new int [] {b[0], -b[2]});
			height.add(new int [] {b[1], b[2]});
		}
		//sort height by start point, get who comes the first
		Collections.sort(height, (a,b)->{
				if(a[0]!=b[0]) return a[0]-b[0];
				return a[1]-b[1];
		});
		//use a priority q to save the height desc
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b - a));
		pq.offer(0);
		//previous height
		int pre = 0;
		//get critical points
		for(int [] h:height){
			if(h[1]<0) pq.offer(-h[1]);
			if(h[1]>0) pq.remove(h[1]);
			int cur = pq.peek();
			if(pre!=cur){
				res.add(new int []{h[0], cur});
				pre = cur;
			}
		}
		
		return res;
    }
}
