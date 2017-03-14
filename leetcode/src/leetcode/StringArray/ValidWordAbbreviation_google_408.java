package leetcode.StringArray;

public class ValidWordAbbreviation_google_408 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean validWordAbbreviation(String word, String abbr) {
        for(int i=0;i<abbr.length;i++){
            if (word.length() == 0) return false;
            //if is number, remove number length
            if (abbr.charAt(i)>'0' && abbr.charAt(i)<='9'){
                
            }
            //else word = word.sub(1);
        }
    }
}
