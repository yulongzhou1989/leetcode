package leetcode.bitManipulation;

public class NonNegtiveIntegersWithoutConsecutiveOnes_600 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findIntegers(int num) {
        StringBuilder bitString = new StringBuilder(Integer.toBinaryString(num)).reverse();
		int n = bitString.length();
		int [] dp1 = new int [n];
		int [] dp2 = new int [n];
		dp1[0] = 1;
		dp2[0] = 1;
		//it fits the fibonacci 
		for(int i=1;i<n;i++){
			dp1[i] = dp1[i-1] + dp2[i-1];//leading with zero and 1
			dp2[i] = dp1[i-1];//leading with 1
		}
		
		int result = dp1[n-1] + dp2[n-1];
		
		//remove dulplicate
		for(int i = n-2;i>=0;i--){
			//find the consecutive 1 from start
			if(bitString.charAt(i)=='1' && bitString.charAt(i+1)=='1') break;
			//consecutive 0, remove that part
			if(bitString.charAt(i)=='0' && bitString.charAt(i+1)=='0')
				result -= dp2[i];
		}
		
		return result;
    }
}
