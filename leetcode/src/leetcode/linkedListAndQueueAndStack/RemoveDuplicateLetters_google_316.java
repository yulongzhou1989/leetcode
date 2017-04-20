package leetcode.linkedListAndQueueAndStack;

public class RemoveDuplicateLetters_google_316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateLetters("bcacb"));
	}

	///removing all letters to the left of s[i],
	//removing all s[i]'s from s.
	public static String removeDuplicateLetters(String s) {
		int [] cnt = new int [26];
        int pos = 0; // the smallest position
        for(int i=0;i<s.length();i++) cnt[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<s.charAt(pos)) pos = i;
            if(--cnt[s.charAt(i)-'a']==0) break;
        }
        //do it recursively 
        return s.length()==0?"":s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}
