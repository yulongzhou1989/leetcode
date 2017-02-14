package leetcode;

public class SentenceScreenFitting_418 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] sentence = new String[] {"a", "bcde"};
		System.out.println(wordsTyping1(sentence, 3,6));
	}
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {

		//append string to each row, if current string exceed left space, new line.
		//
		
		int rowLeft = rows;
		int colsLeft = cols;
		int pos = 0;
		int result = 0;
		
        while (rowLeft>0){
        	colsLeft -= sentence[pos].length();
        	if (colsLeft<0){
        		colsLeft = cols;
        		rowLeft--;
        		continue;
        	}
        	//empty space
        	colsLeft --;
        	if (pos == sentence.length-1){
        		result ++;
        		pos=0;
        	} 
        	else {
        		//move pos
        		pos ++;
        	}
        }
        
        return result;
    }
	
	public static int wordsTyping1 (String [] sentence, int rows, int cols){
		String s = String.join(" ", sentence) + " ";
		int start = 0;
		int l = s.length();
		for(int i=0; i<rows; i++){
			start += cols;
			if (s.charAt(start%l) == ' '){
				start ++;
			} else {
				while(start>0 && s.charAt((start-1)%l) != ' '){
						start --;
				}
			}
		}
		
		return start /s.length();
	}
	
	public static int wordsTypingDP (String[] sentence, int rows, int cols) {
		int [] dp = new int [sentence.length];
		int n = sentence.length;
		for (int i=0, prev = 0, len =0; i<sentence.length; ++i){
			//remove the length of previous word and space
			if (i!=0 && len>0) len -= sentence[i-1].length() + 1;
			//cal the start of next line, how many words one line has
			while(len + sentence[prev%n].length() <=cols) len+=sentence[prev++%n].length()+1;
			dp[i] = prev;
		}
		int count = 0;
		for (int i=0,k=0;i<rows;++i){
			//count how many words one row has and move to start of next row
			//if (dp[k] == k) return 0;
			count += dp[k]-k;
			k = dp[k]%n;
		}
		
		return count/n;
	}
}
