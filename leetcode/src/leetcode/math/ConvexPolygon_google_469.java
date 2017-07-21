package leetcode.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class ConvexPolygon_google_469 {
	
	public boolean isConvex(List<List<Integer>> points) {
        if(points==null || points.size()<3) return false;
		int n = points.size();
        boolean isNeg = false, isPos = false;
		for(int i=0;i<n;i++){
			List<Integer> p1 = points.get(i);
			List<Integer> p2 = points.get((i+1)%n);
			List<Integer> p3 = points.get((i+2)%n);
			int checkRes = check(p1, p2, p3);
			if(checkRes<0){
				isNeg = true;
			}else if (checkRes>0){
				isPos = true;
			}
			
			if(isNeg && isPos) return false;
		}
		
		return true;
    }
	
	private int check(List<Integer> p1, List<Integer> p2, List<Integer> p3){
		return (p2.get(1)-p1.get(1))*(p3.get(0)-p2.get(0)) - (p3.get(1)-p2.get(1))*(p2.get(0)-p1.get(0));
	}
	
	
	//method 2->587. Erect the Fence
	class Point {
       int x;
       int y;
       Point() { x = 0; y = 0; }
       Point(int a, int b) { x = a; y = b; }
    }
    
    public boolean isConvex1(List<List<Integer>> pointsList) {
        if(pointsList==null || pointsList.size()<3) return false;
		//scan from right to left and left to right, and put it into hashSet, if size is the same , it is convex, else, not
        Point [] points = new Point [pointsList.size()];
        for(int i=0;i<pointsList.size();i++){
            points[i] = new Point(pointsList.get(i).get(0), pointsList.get(i).get(1));
        }
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
        
		HashSet<Point> set = new HashSet<>(stack);//remove dulplicates
        
        //System.out.println(set.size());
		
		return set.size()==l;
    }
	
	private int check(Point p1, Point p2, Point p3){
		return (p2.y-p1.y)*(p3.x-p2.x)-(p3.y-p2.y)*(p2.x-p1.x);
	}

}
