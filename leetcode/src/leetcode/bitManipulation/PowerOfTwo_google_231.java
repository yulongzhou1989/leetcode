package leetcode.bitManipulation;

public class PowerOfTwo_google_231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        return (n&(n-1))==0;
    }

}
