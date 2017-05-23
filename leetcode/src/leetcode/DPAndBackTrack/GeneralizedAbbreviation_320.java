package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_320 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateAbbreviations("usaandchinaarefriends"));
	}
	
	public static List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<String> ();
        backtrack(ret, word, 0,"",0);
        return ret;
    }
	
	private static void backtrack(List<String> ret, String word, int pos, String cur, int count){
		if (pos == word.length()){
			if (count>0) cur += count;
			ret.add(cur);
		} else{
			backtrack(ret, word, pos+1, cur, count+1);
			backtrack(ret, word, pos+1, cur+(count>0?count:"")+word.charAt(pos),0);
		}
	}
}
