package leetcode.bitManipulation;

public class NumberComplement_479 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findComplement(int num) {
        //~0 111111111
        int mask = ~0;
		int n=num;
		//000000000101
		//111111111000
		while(n!=0){
			n>>=1;
			mask<<=1;
		}
		
		return (~mask)&(~num);
    }

}
