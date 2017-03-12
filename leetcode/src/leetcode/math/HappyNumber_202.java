package leetcode.math;

import java.util.HashSet;

public class HappyNumber_202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isHappy(int n) {
        return helper (n, new HashSet<Integer>());    
    }
    
    boolean helper(int n, HashSet<Integer> set){
        if (n==1) return true;
        if (n==0) return false;
        if (set.contains(n)) return false;
        else set.add(n);
        int newNum = 0;
        while(n!=0){
            newNum+=(int)Math.pow(n%10,2);
            n=n/10;
        }
        return helper(newNum, set);
    }
}
