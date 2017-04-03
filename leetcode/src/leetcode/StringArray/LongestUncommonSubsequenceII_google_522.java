package leetcode.StringArray;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequenceII_google_522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLUSlength(String[] strs) {
        //sort by string length desc
        Arrays.sort(strs, new Comparator<String>(){
            @Override 
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
        
        for (int i=0;i<strs.length;i++){
        	//check whether strs[i] is sub sequenece of others
            boolean flag = false;
            for(int j=0;j<strs.length;j++){
                if (j!=i && isSub(strs[i], strs[j])){
                    flag = true;
                }
            }
            if(!flag){
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    //check if s1 is substring of s2
    private boolean isSub(String s1, String s2){
        //if len(s1)>len(s2) return false
        if(s1.length()>s2.length()) return false;
        //pos++ when same character
        int j=0;
        for(int i=0;j<s1.length()&&i<s2.length();i++){
            if(s1.charAt(j)==s2.charAt(i)) j++;
        }
        
        return j==s1.length();
    }
}
