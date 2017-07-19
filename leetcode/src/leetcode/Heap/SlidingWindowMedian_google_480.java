package leetcode.Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian_google_480 {
	public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new double [] {};
		//use 2 priority queue, make them balanced(validate element has the same size);<-effective make it balance
		//use a hash map to keep the invalid element
		PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> hi = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int n = nums.length;
		if(n<k) k = n;
		int i = 0;
		//initial first K element
		for(;i<k;i++){
			lo.offer(nums[i]);
		}
		//split half to high
		for(int j=0;j<k/2;j++){
			hi.offer(lo.poll());
		}
		
		double [] res = new double [n-k+1];
		
		//handle the nums left till the end of array
		while(true){
            // System.out.println(Arrays.toString(lo.toArray()));
            // System.out.println(Arrays.toString(hi.toArray()));
            // System.out.println(i + "######");
			res[i-k] = (k%2==1)?lo.peek():(((double)lo.peek()+(double)hi.peek())*0.5);
            if(i>=n) break;
			//System.out.println(res[n-i-1]);
			int balance = 0,//if balanece >0 high need more, else low need more  
			next = nums[i], out = nums[i-k];
			map.put(out, map.getOrDefault(out, 0)+1);
			i++;
            
			if(out<=lo.peek()){//set balance for out element
				balance--;
			}else{
				balance++;
			}
			
			if(next<=lo.peek()){//set balance for in element
				balance++;
				lo.offer(next);
			}else{
				balance--;
				hi.offer(next);
			}
			// System.out.println(Arrays.toString(lo.toArray()));
			// System.out.println(Arrays.toString(hi.toArray()));
			// System.out.println(balance);
            
			//rebalance
			if(!lo.isEmpty() && balance>0){
				hi.offer(lo.poll());
				balance--;
			}
			if(!hi.isEmpty() && balance<0){
				lo.offer(hi.poll());
				balance++;
			}
            // System.out.println(Arrays.toString(lo.toArray()));
            // System.out.println(Arrays.toString(hi.toArray()));
            // System.out.println("==========");
			//remove invalid
			while(!lo.isEmpty() && map.containsKey(lo.peek()) && map.get(lo.peek())>0){
                //System.out.println(lo.peek() + "," +map.get(lo.peek()));
				map.put(lo.peek(), map.get(lo.peek())-1);
				lo.poll();
			}
			while(!hi.isEmpty() && map.containsKey(hi.peek()) && map.get(hi.peek())>0){
				map.put(hi.peek(), map.get(hi.peek())-1);
				hi.poll();
			}
		}
		
		return res;
    }
}
