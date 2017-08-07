import java.util.Stack;

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
                map[s.charAt(j)] =1;//æ›´æ–°jçŠ¶æ€�
                max = Math.max(max, j-i+1);
                j++;//ç§»åŠ¨jä¸‹æ ‡
            }
            map[s.charAt(i)]--;//æ›´æ–°i
        }
        
        return max;
    }
	
	public int[] moveZero(int[] array) {
		// Write your solution here.
		if(array == null || array.length < 2) return array;
		int n = array.length;
		int i = n-1;//slow pointer
		int j = n-1;//fast pointer
		while(j >= 0) {
			while(j>=0){
				if(array[j] == 0) break;
				j--;
			}
			if(j < 0) break;
			swap(j, i, array);
			i--;
		}
		
		return array;
	}  
	
	private void swap(int a, int b, int [] array){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	} 
	
	public class Solution {
		  public Solution() {
		    // write your solution here
		  }
		  
		  Stack<Integer> numberStack = new Stack<>();
			Stack<Integer> minStack = new Stack<>();
				
			public int pop() {
				if(numberStack.isEmpty()) return -1;
				if(minStack.peek() == numberStack.peek())
					minStack.pop();
				return numberStack.pop();
			}

			public void push(int element) {
				if(minStack.isEmpty() || minStack.peek() >= element){
					minStack.push(element);
				}
				numberStack.push(element);
			}

			public int top() {
				if(numberStack.isEmpty()) return -1;
				return numberStack.peek();
			}

			public int min() {
				if(numberStack.isEmpty()) return -1;
				return minStack.peek();
			}
		}
	
}
