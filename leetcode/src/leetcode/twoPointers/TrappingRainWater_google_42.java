package leetcode.twoPointers;

public class TrappingRainWater_google_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int trap(int[] height) {
		//cal the water bin by bin, hold the long bar and find the short bar
			int res = 0;
			int left = 0, right=height.length-1;
			int maxLeft=0, maxRight=0;
			//
			while(left<right) {
				if(height[left]<=height[right]){
					if(height[left]>=maxLeft) maxLeft = height[left];
					else res+=maxLeft-height[left];
					left++;
				}else{
					if(height[right]>=maxRight) maxRight = height[right];
					else res+=maxRight-height[right];
					right--;
				}
			}
		
		   return res;
	    }
}
