package leetcode.StringArray;

public class NextGeaterElementII_google_503 {
	
	public void main(String [] args){
		
	}
	
	public int[] nextGreaterElements(int[] nums) {
        int pos=0;
        int [] res = new int [nums.length];  
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            j=j%nums.length;
            while(j!=i && nums[j]<=nums[i]) j=(j+1)%nums.length;
            res[i] = j==i?-1:nums[j];
        }
        
        return res;
    }
	
	public int[] nextGreaterElements1(int[] nums) {
        int pos=0;
        int [] res = new int [nums.length];  
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            j=j%nums.length;
            while(j!=i && nums[j]<=nums[i]) j=(j+1)%nums.length;
            res[i] = j==i?-1:nums[j];
        }
        
        return res;
    }

}
