package leetcode.Heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream_google_295 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class MedianFinder {

	    PriorityQueue<Integer> minQueue;
		PriorityQueue<Integer> maxQueue;
		
	    /** initialize your data structure here. */
	    public MedianFinder() {
	        minQueue = new PriorityQueue<>();
			maxQueue = new PriorityQueue<>((a, b)->(b-a));
	    }
	    
	    public void addNum(int num) {
			maxQueue.offer(num);
			minQueue.offer(maxQueue.poll());
			if(maxQueue.size()<minQueue.size()){
				maxQueue.offer(minQueue.poll());
			}
	    }
	    
	    public double findMedian() {
	        return minQueue.size()==maxQueue.size()?(double)(minQueue.peek()+maxQueue.peek())/2:maxQueue.peek();
	    }
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */

}
