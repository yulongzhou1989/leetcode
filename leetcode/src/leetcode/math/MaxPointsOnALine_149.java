package leetcode.math;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxPointsOnALine_149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxPoints(Point[] points) {
        //save rational, same line
		if(points.length<=2) return points.length;
		Map<String, HashSet<Integer>> map = new HashMap<>();
		int res = 0;
		for(int i=0;i<points.length;i++){
			int max = 0;
			for(int j=i+1;j<points.length;j++){
				int x = points[i].x-points[j].x;
				int y = points[i].y-points[j].y;
				String rat = "";
				//horizental 
				if(x!=0 && y==0){
					rat = "x/" + points[i].y;
				} else if(x==0 && y!=0){//vertical
					rat = points[i].x + "/y";
				} else{
					int gcd = getGCD(y,x);
					if(x!=0 && y!=0){ 
						x = x/gcd;
						y = y/gcd;
					}
					rat = y+"/"+x;
				}				
				
				HashSet<Integer> set = map.containsKey(rat)?map.get(rat): new HashSet<>();
				set.add(i);
				set.add(j);
				map.put(rat,set);
				max = Math.max(map.get(rat).size(), max);
			}
			res = Math.max(max, res);
		}
		
		return res;
    }
	
	//Greatest common divider
	private int getGCD(int a, int b){
		if(b==0) return a;
		return getGCD(b, a%b);
	}
}
