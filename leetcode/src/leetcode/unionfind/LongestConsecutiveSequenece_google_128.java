package leetcode.unionfind;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenece_google_128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	//general way but stupid
	//check if front and back has saved element 
	/*
	public int longestConsecutive(int[] nums) {
        Map<Integer, Range> map = new HashMap<>();
		int res = 0;
		for(int i=0;i<nums.length;i++){
			int num = nums[i];
			if(!map.containsKey(num)){
				Range cur = new Range(num, num, 1);
				//isolated
				if(!map.containsKey(num-1) && !map.containsKey(num+1)){
					map.put(num, cur);
					res = Math.max(1, res);
				}
				//join left, then cur will be the right
				else if(map.containsKey(num-1)){
					Range left = map.get(num-1);
					int numLeft = left.left;
					Range leftEnd = map.get(numLeft);
					//set left end
					leftEnd.count += 1;
					leftEnd.right = num;
					//set right end
					cur.left = numLeft;
					cur.count = leftEnd.count;
					map.put(num, cur);
					res = Math.max(cur.count, res);
				}
				//join right
				else if(map.containsKey(num+1)){
					Range right = map.get(num+1);
					int numRight = right.right;
					Range rightEnd = map.get(numRight);
					rightEnd.count += 1;
					rightEnd.left = num;
					cur.right = numRight;
					cur.count = rightEnd.count;
					map.put(num, cur);
					res = Math.max(cur.count, res);
				}
				//join both ends
				else{
					
				}
			}
		}
		return res;
    }
	
	public class Range{
		public int left;
		public int right;
		public int count;
		
		public Range(){
			count=0;
		}
		
		public Range(int left, int right, int count){
			this.left = left;
			this.right = right;
			this.count = count;
		}
	}*/

}
