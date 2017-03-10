package leetcode.bitManipulation;

public class HammingDistance_461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while(z!=0){
        	//z&(z-1) erase less significant bit
            z=z&(z-1);
            count++;
        }
        return count;
    }
}
