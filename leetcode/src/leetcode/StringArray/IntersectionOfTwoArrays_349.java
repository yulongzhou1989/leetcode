package leetcode.StringArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays_349 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int n:nums1){
            set.add(n);
        }
        for(int n:nums2){
            if(set.contains(n)){
                set.remove(n);
                list.add(n);
            }
        }
        int [] res = new int [list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}
