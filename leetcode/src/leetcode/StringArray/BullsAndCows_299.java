package leetcode.StringArray;

public class BullsAndCows_299 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getHint(String secret, String guess) {    
        int a=0, b=0;
		int [] idx = new int [10];
		for(int i=0;i<secret.length();i++){
			Character s = secret.charAt(i);
			Character g = guess.charAt(i);
			if(s == g) a++;
			else {
				//guess has s before
				if(idx[s-'0']++<0) b++;
				//secret has g before
				if(idx[g-'0']-->0) b++;
			}
		}
		
		return a+"A"+b+"B";
    }
}
