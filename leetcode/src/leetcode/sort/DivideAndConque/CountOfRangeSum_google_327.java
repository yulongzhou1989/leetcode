package leetcode.sort.DivideAndConque;

public class CountOfRangeSum_google_327 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//merge sort solution
	//merge left part each time to cal the count each partition
	//low<sum[k]-sum[j]<high, k-j is the count for each step
	public int countRangeSum(int[] nums, int lower, int upper) {
	    int n = nums.length;
		//initial the sum array
		long [] sums = new long [n+1];
		for(int i=0;i<n;i++){
			sums[i+1] = sums[i]+nums[i];
		}
        //do merge sort and get the count
		return mergeCount(sums, lower, upper, 0, nums.length+1);
    }
	
	public int mergeCount(long [] sums, int lower, int upper, int start, int end){
		if(end-start<=1) return 0;
		int mid = (start+end)/2;
		int res = mergeCount(sums, lower, upper, start, mid) 
				+ mergeCount(sums, lower, upper, mid, end);
		//save the cached sort result
		long [] cache = new long [end-start];
		int j = mid, k=mid, m = mid;
		
		for(int i=start, ci = 0;i<mid;i++, ci++){
			//fit the lower condition
			while(j<end && sums[j]-sums[i]<lower) j++;
			//fit the higher condition
			while(k<end && sums[k]-sums[i]<=upper) k++;
			//sort the array
			while(m<end && sums[m]<sums[i]) cache[ci++] = sums[m++];
			cache[ci] = sums[i];
//	 			System.out.println("j:"+j +",k:" + k +",m:" +m +",end:" + end
//	 			+",sums:"+Arrays.toString(sums) +", cache:"+Arrays.toString(cache));
			res += k-j;
		}
		
		//merge
		System.arraycopy(cache, 0, sums, start, m-start);
		
		return res;
	}
}
