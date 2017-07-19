package leetcode.math;

public class SmallestGoodBase_google_483 {
	public String smallestGoodBase(String n) { 
    	long num = Long.parseLong(n);
    	for(int i=(int)(Math.log(num)/Math.log(2))+1; i>2; i--) {
    		long back = binarySearch(num, i);
			if(back > 0) return back + "";
    	}
    	return "" + (num - 1);
    }

    private long binarySearch(long n, long len) {
    	long low = (long)Math.pow(n, 1.0 / len),
    		 high = (long)Math.pow(n, 1.0 / (len - 1));
    	while(low <= high) {
    		long mid = (low + high) / 2;
    		long val = 0;
    		for(int i=0; i<len; i++) 
    			val = val * mid + 1;
    		if(val == n) 
    			return mid;
    		else if(val < n)
    			low = mid + 1;
    		else high = mid - 1;
    	}
    	return -1;
    }
}
