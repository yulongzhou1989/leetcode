package leetcode.search;

public class GuessNumberHigherOrLower_google_374 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(guessNumber(2126753390));
	}

	static int x = 1702766719;
	public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(guess(mid) == 0) return mid;
            if(guess(mid) == 1) low = mid+1;
            if(guess(mid) == -1) high = mid-1;
        }
        
        return low;
    }
	
	static int guess(int n){
		if (n==x) return 0;
		else if (n<x) return 1;
		else return -1;
	}
}
