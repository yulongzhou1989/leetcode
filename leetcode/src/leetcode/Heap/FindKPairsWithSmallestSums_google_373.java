package leetcode.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums_google_373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Pair {
		int [] pair;
		int index;
		long sum;
		public Pair(int idx, int a, int b) {
			this.index = idx;
			this.pair = new int [] {a,b};
			sum = (long)a+(long)b;
		}
	}
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> res = new ArrayList<>();
		if(nums1.length==0 || nums2.length==0) return res;
		//use priority queue to save num1.length-1 pairs
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b){
				return Long.compare(a.sum,b.sum);
			}
		});
		//initial pq
		for(int i=0;i<nums1.length && i<k; i++){
			pq.offer(new Pair(0, nums1[i], nums2[0]));
		}
		//get res
		for(int i=0;i<k && !pq.isEmpty();i++){
			Pair p = pq.poll();
			res.add(new int [] {p.pair[0], p.pair[1]});
			if(p.index<nums2.length-1){
				int next = p.index+1;
				pq.offer(new Pair(next, p.pair[0], nums2[next]));
			}
		}
		
		return res;
    }
}
