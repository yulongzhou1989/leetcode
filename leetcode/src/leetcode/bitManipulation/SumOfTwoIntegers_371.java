package leetcode.bitManipulation;

public class SumOfTwoIntegers_371 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getSum(int a, int b) {
		//a^b find diff bit, a&b find a carry
        return b==0?a:getSum(a^b, (a&b)<<1);
    }
	
	public static int getSubstract(int a, int b) {
		//a^b find diff bit, a&b find a carry
        return b==0?a:getSubstract(a^b, (~a&b)<<1);
    }

	// Get negative number
	public int negate(int x) {
		return ~x + 1;
	}
	
	/*
	 * 1111 is -1, in two's complement
	 * 1110 is -2, which is ~2 + 1, ~0010 => 1101, 1101 + 1 = 1110 => 2
	 * 1101 is -3, which is ~3 + 1
	 * so if you want to get a negative number, you can simply do ~x + 1
	 */
}
