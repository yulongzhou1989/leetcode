package leetcode.hashmap;

import java.util.HashMap;

public class NumberOfBoomerangs_google_447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numberOfBoomerangs(int[][] points) {
        if(points==null || points.length==0 || points[0].length==0) return 0;
		//iterate array, and count the distance of diff points. Count each points the same distance
		int sum = 0;
		int n = points.length;
		
		HashMap<Integer, Integer> map = new HashMap<>();//dist->count
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i!=j && !(points[i][0]==points[j][0] && points[i][1]==points[j][1])){//not the same point
					int dis = dist(points[i], points[j]);
					map.put(dis, map.getOrDefault(dis, 0)+1);
				}
			}
			//count diff boomerangs
			for(int k:map.values()){
				sum += k*(k-1);
			}
			
			map.clear();
		}
		
		return sum;
    }
	
	private int dist(int [] p1, int [] p2){
	    int x = p1[0] - p2[0];
	    int y = p1[1] - p2[1];
		return x*x + y*y;
	}

}
