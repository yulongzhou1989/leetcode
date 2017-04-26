package leetcode.twoPointers;

public class LongestSubstringWithAtMostTwoDistinctCharacters_google_159 {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0) return 0;
		int k = 2;
		int [] count = new int [256];
		int len = 0;
		int max = 0;
		//slide window, j is the start point and i is the end point.
		//if meet different character, len ++, if len>k, move left pointer,
		//keeping pop out the character until pop out a different character to make the length
		//back to k again.
		for(int i=0,j=0;i<s.length();i++){
			if(count[s.charAt(i)]++==0) len++;
			if(len>k){
				while(--count[s.charAt(j++)]>0);
				len--;
			}
			
			max = Math.max(max, i-j+1);
		}
	
		return max;
    }
}
