package contest;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElementIII {
	public static void main(String [] args){
		System.out.println(nextGreaterElement(12));
	}
	
	public static int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<Integer>();
        while(n>0){
            list.add(0,n%10);
            n/=10;
        }
        Integer [] nums = list.toArray(new Integer [list.size()]);
        
        int i=0;
        for(i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]) 
                break;
        }
        if(i<0){
            return -1;
        }
        else{
            int val=nums[i-1];
            int j=nums.length-1;
            while(j>=i){
                if(nums[j]>val)
                    break;
                j--;
            }
            swap(nums,j,i-1);
            reverse(nums,i,nums.length-1);
        }
        
        
        int res = 0;
        for(int j=0;j<nums.length;j++){
             res+=nums[j]*Math.pow(10,nums.length-1-j);
        }
        
        return res;
    }
    
    private static void swap(Integer [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void reverse(Integer [] nums, int start, int end){
        if(start>end) return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(nums,i,start+end-i);
    }
}
