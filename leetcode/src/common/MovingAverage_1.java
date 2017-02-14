package common;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage_1 {

	private double sum;
	private Queue<Integer> q;
	private int size;
	
	public MovingAverage_1(int size){
		this.sum = 0;
		this.q = new LinkedList<Integer>();
		this.size = size;
	}
	
	public double next(int val){
		if (this.q.size() == this.size){
			this.sum -= this.q.remove();
		}
		this.sum += val;
		this.q.add(val);
		return sum/q.size();
	}
}
