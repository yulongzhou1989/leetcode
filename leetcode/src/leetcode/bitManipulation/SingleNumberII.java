package leetcode.bitManipulation;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] nums) {
        //use m = log2K saving K different status.
		//use m 32bit integer saving 32 m bit status.
		//xm = xm^(x(m-1)&.....&i), 
		//32th|31th|30th| ..... |1th -- original number
		// |
		//1th |1th |1th | ..... |1th -- 1/m
		//2th |2th |2th | ..... |2th -- 2/m
		//.......
		//mth |mth |mth | ..... |mth -- m/m
		
        int x1 = 0, x2=0, mask=0;
		
		for(int i=0;i<nums.length;i++){
			x2 ^= (x1&nums[i]);
			x1 ^= nums[i];
			mask = ~(x1 & x2);//K->(011), to INITIALIZE when reach k if(xj==1) maskJ = xj else maskJ = ~xj
			x2 &= mask;
			x1 &= mask;
		}
		
		return x1;
    }
}
