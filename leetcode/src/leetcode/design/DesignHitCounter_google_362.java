package leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignHitCounter_google_362 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class HitCounter1 {

	    Map <Integer, Integer> hitMap;
	    static final int FiveMinutes = 300;

	    /** Initialize your data structure here. */
	    public HitCounter1() {
	        hitMap = new HashMap<Integer, Integer>();
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        if (!hitMap.containsKey(timestamp)){
	            hitMap.put(timestamp, 1);
	        } else {
	            hitMap.put(timestamp, hitMap.get(timestamp)+1);
	        }
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        int counter = 0;
	        for (Integer key: hitMap.keySet()){
	            if (timestamp-FiveMinutes>=key){
	              continue;  
	            } 
	            counter+=hitMap.get(key);
	        }
	        return counter;
	    }
	}

	/**
	 * Your HitCounter object will be instantiated and called as such:
	 * HitCounter obj = new HitCounter();
	 * obj.hit(timestamp);
	 * int param_2 = obj.getHits(timestamp);
	 */
	
	
	/**
	 * Queue solution
	 */
	public class HitCounter {

	    Queue<Integer> hitQ;
	    static final int FiveMinutes = 300;

	    /** Initialize your data structure here. */
	    public HitCounter() {
	        hitQ = new LinkedList<Integer> ();
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        hitQ.add(timestamp);
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        while (!hitQ.isEmpty() && (timestamp-FiveMinutes)>=hitQ.peek()){
	            hitQ.poll();
	        }
	        return hitQ.size();
	    }
	}

	/**
	 * Your HitCounter object will be instantiated and called as such:
	 * HitCounter obj = new HitCounter();
	 * obj.hit(timestamp);
	 * int param_2 = obj.getHits(timestamp);
	 */
	
}
