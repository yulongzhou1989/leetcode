package leetcode.DFS;

public class ZumaGame_488 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	final int MAXBALL = 6;
	
	public int findMinStep(String board, String hand) {
        int [] ballsInhand = new int [32];
		for(int i=0;i<hand.length();i++){
			ballsInhand[hand.charAt(i)-'A']++;
		}
		board += "#";
		int res = countBallsNeeded(board, ballsInhand);
		return res == MAXBALL? -1:res;
    }
	
	private int countBallsNeeded(String board, int [] ballsInhand){
		//>=3 balls boom!
		board = removeConsecutives(board);
		if(board.equals("#")) return 0;
		int res = MAXBALL, need = 0;
		//add enough balls in each space
		for(int i=0,j=0;j<board.length();j++){
			if(board.charAt(i) == board.charAt(j)) continue;
			need = 3-(j-i);
			if(ballsInhand[board.charAt(i)-'A']>= need){
				ballsInhand[board.charAt(i)-'A'] -= need;
				res = Math.min(res, need + countBallsNeeded(board.substring(0, i) + board.substring(j), ballsInhand));
				ballsInhand[board.charAt(i)-'A'] += need;
			}
			i=j;
		}
		
		return res;
	}
	
	private String removeConsecutives(String s){
		for(int i=0, j=0;j<s.length();j++){
			if(s.charAt(i) == s.charAt(j)) continue;
			if(j-i>=3) return removeConsecutives(s.substring(0,i) + s.substring(j));
			else i = j;
		}
		
		return s;
	}

}
