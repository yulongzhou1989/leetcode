package leetcode.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ConvexPolygon_google_469 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isConvex(List<List<Integer>> points) {
        if(points==null || points.size()<3) return false;
		Stack<List<Integer>> stack = new Stack<>();
		Arrays.sort(points, new Comparator<List<Integer>>(){
			
		});
		//left to right
    }
	
	private int check(List<Integer> p1, List<Integer> p2, List<Integer> p3){
		return (p3.get(1)-p2.get(1))*(p2.get(0)-p1.get(0)) - (p2.get(1)-p1.get(1))*(p3.get(0)-p2.get(0));
	}

}
