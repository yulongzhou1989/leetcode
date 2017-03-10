package leetcode.bitManipulation;

public class CountingBits_338 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] countBits1(int num) {
        if (num==0) return new int [] {0};
        
        int [] res = new int [num+1];
        res[0] = 0;
        res[1] = 1;
        int base = 2;
        for(int i=2,k=1;i<=num;i++){
            //if i is pow(2,k+1), eg. 4, 8, 16, 32...., reset base
            if (i==Math.pow(2,k+1)) {
                base = i;
                k++;
            }
            res[i] = res[i%base]+1;
        }
        return res;
    }
	
	//f(i) = f(i/2) + i%2; except last digit, how many ones? e.g. 12-1100->6-0110, 13-1101->0110 + 1
    public int[] countBits(int num) {
        int [] res = new int [num+1]; 
        for (int i=0; i<=num;i++){
            res[i] = res[i>>1]+(i&1);
        }
        
        return res;
    }
}
