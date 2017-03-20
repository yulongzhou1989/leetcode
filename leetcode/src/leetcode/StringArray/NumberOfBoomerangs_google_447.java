package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs_google_447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] points = {{1,1},{2,2},{3,3}};
		System.out.println(numberOfBoomerangs(points));
	}

	//On*n time, On memo
	public static int numberOfBoomerangs(int[][] points) {
        if (points.length<2) return 0;
        //key distance, val how many times the same distance, 2D vector
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int result = 0;
        for(int i=0;i<points.length;i++){
            for (int j=0;j<points.length;j++){
                if (i==j) continue;
                double dist = getDist(points[i], points[j]);
                if (!map.containsKey(dist))
                    map.put(dist,1);
                else 
                    map.put(dist, map.get(dist)+1);
            }
            //Only 2 points, so C(n,2)
            for (Integer val:map.values()){
                result += val*(val-1);
            }
            map.clear();
        }
        return result;
    }
    
    static double getDist(int [] point1, int [] point2){
        return Math.sqrt(Math.pow(point1[0]-point2[0], 2)+Math.pow(point1[1]-point2[1], 2));
    }
}
