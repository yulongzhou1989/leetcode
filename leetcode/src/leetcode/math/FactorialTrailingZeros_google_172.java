package leetcode.math;

public class FactorialTrailingZeros_google_172 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trailingZeroes(int n) {
        //num of factor of 5/25/125....
        return n==0?0:(n/5+trailingZeroes(n/5));
    }
}
