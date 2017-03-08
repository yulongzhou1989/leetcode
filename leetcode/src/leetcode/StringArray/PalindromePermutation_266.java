package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation_266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                //map.put(s.charAt(i), 1+map.get(s.charAt(i)));
            	map.remove(map.get(s.charAt(i)));
            }
        }
        
        return map.size()<=1?true:false;
        
//        int sum = 0;
        
//        for (Integer val:map.values()){
//            if (val%2!=0)
//                sum++;
//        }
        
//        return sum<=1?true:false;
    }

}
