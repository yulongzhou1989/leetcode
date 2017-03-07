package leetcode.StringArray;

import java.util.Arrays;

public class FindTheDifference_google_389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findTheDifference("abcd", "abcde"));
	}

	public static  char findTheDifference(String s, String t) {
        char [] sc = s.toCharArray();
        char [] tc = s.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i=0; i<sc.length; i++){
            if (sc[i]!=tc[i]) return tc[i];
        }
        return tc[sc.length];
    }
}
