package leetcode.StringArray;

import java.util.HashSet;

public class LineReflection_google_356 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //find boundary points
        for(int [] point: points){
            max = Math.max(point[0],max);
            min = Math.min(point[0],min);
            set.add(point[0]+","+point[1]);
        }
        //check reflection
        int sum = max+min;
        for(int [] point:points){
            if(!set.contains((sum-point[0])+","+point[1])) return false;
        }
        return true;
    }
}
