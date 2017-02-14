package common;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

	public int size;
	public List<Integer> list;
	public double sum;
	
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
    	this.size = size;
    	this.list = new ArrayList<Integer> ();
    	this.sum = 0;
    }
    
    public double next1(int val) {
        list.add(val);
        int len = list.size();
        int n = len<size?len:size;
        double sum = 0;
        for (int i=0;i<n;i++){
        	sum += list.get(len-i-1);
        }
        return sum/n;
    }
    
    public double next(int val) {
    	list.add(val);
        this.sum += val;
        int prev = 0;
        int n = 0;
        if (list.size()>size){
        	n = size;
        	prev = list.get(list.size()-size-1);
        }else {
        	n = list.size();
        }
        
        this.sum -= prev;
        return (double) this.sum/n;
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
