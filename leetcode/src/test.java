
public class test {
	
	public int binarySearch(int [] nums, int target){//find a target
		int s = 0;
		int e = nums.length-1;
		while(s<=e){
			int m = s+(e-s)/2;
			if(nums[m]>target){
				e = m-1;
			}else if(nums[m]<target){
				s = m+1;
			}else{
				return m;
			}
		}
		
		return -1;
	}
	
	public int binarySearch1(int [] nums, int target){//find the insert index
		if(nums.length==0) return 0;
		int s = 0;
		int e = nums.length-1;
		if(nums[s]>=target) return s;
		if(nums[e]<target) return e;
		
		while(s<e){
			int m = s+(e-s)/2;
			if(nums[m]>=target){
				e = m;
			}else{
				s = m+1;
			}
		}
		
		return s;
	}
	
	//
	public int lengthOfLongestSubstring(String s) {
        // write your code here
        int n = s.length();
        int [] map = new int [256];
        int max = 0;
        for(int i=0,j=0;i<n;i++){
            while(j<n && map[s.charAt(j)]==0){
                map[s.charAt(j)] =1;//更新j状态
                max = Math.max(max, j-i+1);
                j++;//移动j下标
            }
            map[s.charAt(i)]--;//更新i
        }
        
        return max;
    }
	
}
