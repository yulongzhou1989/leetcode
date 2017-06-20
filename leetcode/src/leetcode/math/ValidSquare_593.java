package leetcode.math;

import java.util.HashSet;

public class ValidSquare_593 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(p1.length==0 || p2.length==0 || p3.length==0 || p4.length==0) return false;
		HashSet<Integer> set = new HashSet<>();
		set.add(calDis(p1,p2));
		set.add(calDis(p1,p3));
		set.add(calDis(p2,p3));
		set.add(calDis(p1,p4));
		set.add(calDis(p2,p4));
		set.add(calDis(p3,p4));
		//in case of zero distance 
		return !set.contains(0) && set.size()==2;
	}
	
	private int calDis(int [] p1, int [] p2){
		return (p2[1]-p1[1])*(p2[1]-p1[1]) + (p2[0]-p1[0])*(p2[0]-p1[0]);
	}
}
