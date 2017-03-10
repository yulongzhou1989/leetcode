package leetcode.StringArray;

public class DetectCapital_google_520 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//ASCII check, A-Z 65->90, a-z 97->122
	public boolean detectCapitalUse(String word) {
		int cnt = 0;
		for(char c: word.toCharArray()) if('Z'-c>=0) cnt++;
		return ((cnt==0 || cnt==word.length() || (cnt==1 && 'Z' - word.charAt(0)>=0)));
	}
	
	//REGEX WAY
	public boolean detectCapitalUse_reg(String word) {
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
	//STUPID WAY!!!
    public boolean detectCapitalUse_stupid(String word) {
        if (word.length()==0) return false;
        if (word.length()==1) return true;
        boolean preIsUpper = Character.isUpperCase(word.charAt(0));
        int start = 0;
        if(!preIsUpper){
            start=1;
            preIsUpper = false;
        }else {
            start=2;
            preIsUpper = Character.isUpperCase(word.charAt(1));
        }
        for(int i=start;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i)) != preIsUpper) return false;
            preIsUpper = Character.isUpperCase(word.charAt(i));
        }
        return true;
    }
}
