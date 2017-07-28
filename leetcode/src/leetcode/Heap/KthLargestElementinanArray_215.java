package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinanArray_215 {
	//Heap way
	public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0) return 0;
		
		int m = matrix.length, n = matrix[0].length;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
			@Override
			public int compare(Pair p1, Pair p2){
				return p1.val - p2.val;
			}
		});
		//insert first column
		for(int i=0;i<m;i++){
			pq.offer(new Pair(i, 0, matrix[i][0]));
		}
		
		//add next col same row element
		for(int i=0;i<k-1;i++){
			Pair cur = pq.poll();
			if(cur.y==n-1)
				continue;
			pq.offer(new Pair(cur.x, cur.y+1, matrix[cur.x][cur.y+1]));
		}
		
		return pq.peek().val;
    }

	class Pair {
		int x;
		int y;
		int val;
		
		public Pair(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}
