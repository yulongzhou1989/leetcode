package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
	public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0 || points[0].length==0)
			return 0;
		
		Arrays.sort(points, new Comparator<int []>(){
			@Override
			public int compare(int [] a, int [] b){
				if(a[1] == b[1]) return b[0] - a[0];
				else return a[1] - b[1];
			}
		});
		
		int count = 1;
		int n = points.length;
		int arrPos = points[0][1];
		for(int i=1;i<n;i++){
			while(i<n && points[i][0]<=arrPos){
				i++;
			}
			if(i<n){
				arrPos = points[i][1];
				count++;
			}
		}
		
		return count;
    }
	
}
