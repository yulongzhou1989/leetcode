package leetcode.math;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine_149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int maxPoints(Point[] points) {
		if(points==null) return 0;
		if(points.length<3) return points.length;
		
		int res = 0;
		for(int i=0;i<points.length;i++){
			int max=0, overlap=0;
			//Map to save the rational, y->x, count
			Map<String, Integer> map = new HashMap<>();
			//count the points in the same line;
			for(int j=i+1;j<points.length; j++){
				int x = points[i].x-points[j].x;
				int y = points[i].y-points[j].y;
				if(x==0 && y==0){
				    overlap++;
				    continue;
				}
				String rat;
				if(x!=0 && y==0){//horizontal
					rat = "x/" + points[i].y;
				}
				else if(x==0 && y!=0){//vertical
					rat = points[i].x + "/y";
				}
				else{
    				int gcd = getGCD(y,x);
    				x = x/gcd;
    				y = y/gcd;
					rat = x + "/" + y;
				}
				
				map.put(rat, map.getOrDefault(rat, 0)+1);
				max = Math.max(map.get(rat), max);
			}
			res = Math.max(res, max+overlap+1);
		}
		
		return res;
	}
	
	//Greatest Common divider
	private int getGCD(int y, int x){
		if(x==0) return y;
		return getGCD(x, y%x);
	}
}
