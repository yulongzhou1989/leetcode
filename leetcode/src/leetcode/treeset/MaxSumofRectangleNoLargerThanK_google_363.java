package leetcode.treeset;

import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK_google_363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			int [] col = new int [m];
			for(int j=i;j<n;j++){
				for(int l=0;l<m;l++){
					col[l] += matrix[l][j]; 
				}
				
				//find the max subarray no more than k ->O(nlogn) time
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				int curSum =0;
				for(int l=0;l<m;l++){
					curSum += col[l];
					Integer ceiling = set.ceiling(curSum-k);
                    //System.out.println(curSum + ", c:" + ceiling);
					if(ceiling!=null){
						maxSum = Math.max(maxSum, curSum-ceiling);
					}
					set.add(curSum);
				}
			}
		}
		
		return maxSum;
    }
}
