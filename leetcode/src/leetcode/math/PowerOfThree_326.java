package leetcode.math;

public class PowerOfThree_326 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Max 3 pow in integer range is power(3,19)
    public boolean isPowerOfThree(int n) {
        return (n>0&&Math.pow(3,19)%n==0);
    }
}
