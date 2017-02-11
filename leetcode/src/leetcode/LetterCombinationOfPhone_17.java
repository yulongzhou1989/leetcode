package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("234"));
	}

	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0) return new ArrayList<String> ();
        List<String> l = new ArrayList<String> ();
        String [] letters = new String [] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(l, new StringBuilder(), digits, letters, 0);
        return l;
    }
	
	public static void helper (List<String> l, StringBuilder sb, String digits, String [] letters, int offset){
		if(offset==digits.length()){
			l.add(sb.toString());
		}else {
			String letter = letters[digits.charAt(offset) - '0'];
			for (int i=0;i<letter.length();i++){
				sb.append(letter.charAt(i));
				helper(l, sb, digits, letters, offset +1);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	
}
