package leetcode.bitManipulation;

public class NumberOf1Bits_191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
        	n=n&(n-1);
        	count ++;
        }
        return count;
    }
}
