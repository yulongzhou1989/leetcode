package leetcode.DPAndBackTrack;

public class PowXN_google_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public double myPow(double x, int n) {
        if(n==0) return 1;
        if (n==Integer.MIN_VALUE) {
            if (Math.abs(x)==1) return 1;
            return Math.abs(x)>1?0:Double.MAX_VALUE;
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        return n%2==0?myPow(x*x, n/2):x*myPow(x*x,n/2);
    }
}
