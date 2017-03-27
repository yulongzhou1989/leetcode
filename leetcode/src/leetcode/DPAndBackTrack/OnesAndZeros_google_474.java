package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class OnesAndZeros_google_474 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = {"10","0001","111001","1","0"};
		System.out.println(findMaxForm1(strs,3,4));
	}

	
//    public static int findMaxForm(String[] strs, int m, int n) {
//        return helper(strs, m, n, new ArrayList<String>(), 0, 0);
//    }
//    
    public static List<List<String>> findMaxForm1(String[] strs, int m, int n) {
    	List<List<String>> tempList = new ArrayList<List<String>>();
    	helper(strs, m, n, new ArrayList<String>(), 0, 0, tempList);
        return tempList;
    }
    
    private static int helper(String []  strs, int m, int n, List<String> tempList, int max, int pos, List<List<String>> res){
        //if m==0 and n==0 find the correct string
        if (m==0 && n==0) {
        	res.add(new ArrayList<String>(tempList));
        	return tempList.size();
        }
        if (m<0 || n<0) return -1;
        
        for(int i=pos;i<strs.length;i++){
            tempList.add(strs[i]);
            int [] counts = countOnesAndZeros(strs[i]);
            max = Math.max(helper(strs, m-counts[0], n-counts[1], tempList, max, i+1, res), max);
            tempList.remove(tempList.size()-1);
        }
        
        return max;
    }
    
    //count number of 0s and 1s
    private static int [] countOnesAndZeros(String s){
        int ones = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') ones++;
        }
        return new int [] {s.length()-ones, ones};
    }
}
