package leetcode.DPAndBackTrack;

public class EliminateGame_bt_390 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int lastRemaining(int n) {
        return left2Right(n);
    }
	
	private int left2Right(int n){
		return n==1?1:2*right2Left(n/2);
	}
	
	private int right2Left(int n){
		//1,2
		if(n<=2) return 1;
		//1,2,3
		return n%2==1?2*left2Right(n/2):2*left2Right(n/2)-1;
	}
}
