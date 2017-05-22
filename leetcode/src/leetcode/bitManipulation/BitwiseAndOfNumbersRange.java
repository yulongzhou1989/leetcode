package leetcode.bitManipulation;

public class BitwiseAndOfNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rangeBitwiseAnd(int m, int n) {
        //in the range must have an odd and an even, last digit 0
		//>>k to find when m and n become the same
		//eliminated m<<k
		if(m<=0 || m>n) return 0; 
		if(m==n) return m;
		int diff = 1;
		while(n!=m){
			m>>=1;
			n>>=1;
			diff<<=1;
		}
		
		return diff*n;
    }

}
