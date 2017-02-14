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

//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
//For example,
//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3