package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(readBinaryWatch(2));
	}
	
	public static List<String> readBinaryWatch(int num) {
        List <String> l = new ArrayList<String> ();
        int nums1[] = {1,2,4,8};
        int nums2[] = {1,2,4,8,16,32};
        for(int i=0;i<=num;i++){
        	List<Integer> list1 = new ArrayList<Integer>();
        	List<Integer> list2 = new ArrayList<Integer>();
        	generateDigit(list1, nums1, i, 0, 0);
        	generateDigit(list2, nums2, num - i, 0, 0);
        	for (Integer n1 : list1){
        		if (n1>=12) continue;
        		for (Integer n2: list2){
        			if (n2>59) continue;
        			l.add(n1+":"+(n2<10?"0":"") +n2 );
        		}
        	}
        }
        
        
        return l;
    }
	
	public static void generateDigit(List<Integer> ret, int [] nums, int count, int start, int sum){
		if (count == 0){
			ret.add(sum);
		}
		for (int i=start; i<nums.length; i++){
			generateDigit(ret, nums, count-1, i+1, sum+nums[i]);
		}
	}

}
