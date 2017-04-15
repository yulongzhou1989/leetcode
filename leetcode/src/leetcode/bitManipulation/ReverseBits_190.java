package leetcode.bitManipulation;

public class ReverseBits_190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            result+=n&1;
            n = n>>>1;
            if(i<31)
                result = result<<1;
        }
        
        return result;
    }
}
