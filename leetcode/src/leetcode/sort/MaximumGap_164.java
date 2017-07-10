package leetcode.sort;

import java.util.Arrays;

public class MaximumGap_164 {
	public int maximumGap(int[] num) {
		// get the averge gap, then put each number to bucket, find the max difference between to adjacent buckets
		if(num.length<2) return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int len = num.length;
		//find max value and min value
		for(int i:num){
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int gap = (int)Math.ceil((double)(max-min)/(len-1));
		int [] bucketMax = new int [len-1];//max and min don't need to put into bucket
		int [] bucketMin = new int [len-1];
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		
		for(int i:num){
            if(i==min || i==max) continue;
			int idx = (int)(i-min)/gap;
			bucketMax[idx] = Math.max(bucketMax[idx], i);
			bucketMin[idx] = Math.min(bucketMin[idx], i);
		}
		int pre = min;
		int maxGap = Integer.MIN_VALUE;
		for(int i=0;i<len-1;i++){
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE)
            // empty bucket
                continue;
			maxGap = Math.max(bucketMin[i]-pre, maxGap);
			pre = bucketMax[i];
		}
		
		return Math.max(maxGap, max-pre);
    }	
}
