package leetcode.StringArray;

import java.util.HashSet;

public class PerfectRectangle_google_391 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isRectangleCover(int[][] rectangles) {
        //check sum of the area is the same with min(x1,y1), max(x2,y2)
		//remove end points when dulplicate. Point left should be only 4 end points
		int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE, p=Integer.MIN_VALUE, q=Integer.MIN_VALUE;
		int sum=0;
		HashSet<String> set = new HashSet<>();
		
		for(int [] rec: rectangles){
			int x1 = rec[0];
			int y1 = rec[1];
			int x2 = rec[2];
			int y2 = rec[3];
			sum += (x2-x1)*(y2-y1);
			a = Math.min(x1,a);
			b = Math.min(y1,b);
			p = Math.max(x2,p);
			q = Math.max(y2,q);
			
			//this point exited before, remove this point, check 4 corner points
			if(!set.add(x1+","+y1)) set.remove(x1+","+y1);
			if(!set.add(x1+","+y2)) set.remove(x1+","+y2);
			if(!set.add(x2+","+y1)) set.remove(x2+","+y1);
			if(!set.add(x2+","+y2)) set.remove(x2+","+y2);
		}
		
		if(!set.contains(a+","+b) || !set.contains(a+","+q) || !set.contains(b+","+p) || !set.contains(b+","+q) || set.size()!=4) 
			return false;
		
		return sum == (p-a)*(q-b);
    }
}
