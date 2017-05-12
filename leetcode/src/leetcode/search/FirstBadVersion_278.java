package leetcode.search;

public class FirstBadVersion_278 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBadVersion(int mid){
		return true;
	}
	
	 public int firstBadVersion(int n) {
	        int l = 1;
	        int h = n;
	        
	        while(l<h){
	            int mid = l+(h-l)/2;
	            if(!isBadVersion(mid)) l=mid+1;
	            else h=mid;
	        }
	        
	        return l;
	}

}
