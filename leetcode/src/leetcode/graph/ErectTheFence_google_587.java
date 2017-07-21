package leetcode.graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class ErectTheFence_google_587 {
	//check the second line is clock wise or anti-clock wise 
	private int check(Point p1, Point p2, Point p3){
		return (p2.y-p1.y)*(p3.x-p2.x)-(p3.y-p2.y)*(p2.x-p1.x);
	}
	
	public List<Point> outerTrees(Point[] points) {
		List<Point> res = new ArrayList<>();
        if(points.length==0) return res;
		Stack<Point> stack = new Stack<>();
		int l = points.length;
		Arrays.sort(points, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2){
				if(p1.x == p2.x) return p2.y-p1.y;
				else return p1.x-p2.x;
			}
		});
		
		for(int i=0;i<l;i++){
			while(stack.size()>=2 && check(stack.get(stack.size()-2), stack.peek(), points[i])>0){
				stack.pop();
			}
			stack.push(points[i]);
		}
		
        //stack.pop();
		
        for(int i=l-1;i>=0;i--){
			while(stack.size()>=2 && check(stack.get(stack.size()-2), stack.peek(), points[i])>0){
				stack.pop();
			}
			stack.push(points[i]);
		}
        
		HashSet<Point> set = new HashSet<>();//remove dulplicates
		while(!stack.isEmpty()){
			Point p = stack.pop();
			if(!set.contains(p))
				res.add(p);
			set.add(p);
		}
		
		return res;
    }
	
}
