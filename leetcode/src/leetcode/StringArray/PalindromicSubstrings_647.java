package leetcode.StringArray;

public class PalindromicSubstrings_647 {
	int count = 0;
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            checkPal(s, i, i+1);//even
            checkPal(s, i, i);//odd
        }
        
        return count;
    }
    
    private void checkPal(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
    }
}
