package leetcode.bitManipulation;

public class PowerOfFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfFour(int n) {
        return n>0 && (n&(n-1))==0 && (n&0x55555555)!=0;
    }
}
