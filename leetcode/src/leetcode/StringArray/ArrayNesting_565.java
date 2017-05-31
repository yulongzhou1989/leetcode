package leetcode.StringArray;

import java.util.HashSet;

public class ArrayNesting_565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {5,4,0,3,1,6,2};
		System.out.println(arrayNesting(nums));
	}
	
	
	static int max = Integer.MIN_VALUE;
    public static int arrayNesting(int[] nums) {
        if(nums.length<2) return nums.length;
        
        for(int i=0;i<nums.length;i++)
        {
            int res = 0;
            int pos = i;
            while(nums[pos]!=-1){
                //System.out.println("pos1:" + pos);
                int p = pos;
                res++;
                pos = nums[pos];
                nums[p] = -1;
            }
            max = Math.max(res, max);
            System.out.println("max:" + max);
        }
        

        return max;
    }
	
	//int max = Integer.MIN_VALUE;
    public int arrayNesting1(int[] nums) {
        if(nums.length<2) return nums.length;
        int [] count = new int [nums.length];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        int pos = 0;
        while(!set.isEmpty()){
            System.out.println("pos:" + pos);
            int res = 0;
            while(set.contains(pos)){
                System.out.println("pos1:" + pos);
                res++;
                set.remove(pos);
                pos = nums[pos];
            }
            max = Math.max(res, max);
        }
        
        return max;
    }

}
