package leetcode.DPAndBackTrack;

public class PaintFence_google_276 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numWays(int n, int k) {
        if (n==0 || k==0) return 0;
        if (n==1) return k;
        int diffNum = k*(k-1);
        int sameNum = k;
        
        for (int i=2;i<n;i++){
            int temp = diffNum;
            diffNum = (diffNum+sameNum)*(k-1);
            sameNum = temp;
        }
        
        return diffNum+sameNum;
    }
}
