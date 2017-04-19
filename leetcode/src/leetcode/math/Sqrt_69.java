package leetcode.math;

public class Sqrt_69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mySqrt(int x) {
        if(x==0) return 0;
		long r = x;
		while(r*r>x){
			r = (r+x/r)/2;
		}
		
		return (int) r;
    }
}
