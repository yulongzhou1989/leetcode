package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII_google_247 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    public List<String> helper(int n, int m){
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n==1) return new ArrayList<String>(Arrays.asList("0","1","8"));
        
        List<String> list = helper(n-2, m);
        List<String> res = new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            String s = list.get(i);
            if (n!=m) res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("9"+s+"6");
            res.add("8"+s+"8");
        }
        
        return res;
    }

}
