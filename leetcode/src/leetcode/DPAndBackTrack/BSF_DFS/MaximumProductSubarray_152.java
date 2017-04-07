package leetcode.DPAndBackTrack.BSF_DFS;

public class MaximumProductSubarray_152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {2,3,-2,4,6};
		System.out.println(maxProduct(nums));
	}
	

	public static int maxProduct(int[] A) {
		// store the result that is the max we have found so far
	    int r = A[0];

	    // imax/imin stores the max/min product of
	    // subarray that ends with the current number A[i]
	    for (int i = 1, imax = r, imin = r; i < A.length; i++) {
	        // multiplied by a negative makes big number smaller, small number bigger
	        // so we redefine the extremums by swapping them
	        if (A[i] < 0)
	            swap(imax, imin);

	        // max/min product for the current number is either the current number itself
	        // or the max/min by the previous number times the current one
	        imax = Math.max(A[i], imax * A[i]);
	        imin = Math.min(A[i], imin * A[i]);

	        // the newly computed max value is a candidate for our global result
	        r = Math.max(r, imax);
	    }
	    return r;
    }
	
	private static void swap(int i, int j){
		int temp = i;
		i = j;
		j = temp;
	}

}
