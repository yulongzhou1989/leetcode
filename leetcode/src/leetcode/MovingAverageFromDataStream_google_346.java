package leetcode;

import common.MovingAverage_1;

public class MovingAverageFromDataStream_google_346 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage_1 ma = new MovingAverage_1(3);
	
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));

	}


}
